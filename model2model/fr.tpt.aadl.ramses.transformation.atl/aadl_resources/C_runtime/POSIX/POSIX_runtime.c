#include <pthread.h>
#include <sched.h>

struct periodic_thread_info
{
	const unsigned int period;
	int sig;
	sigset_t alarm_sig;
	int wakeups_missed;
};

pthread_t create_thread (unsigned int priority,
						 unsigned int stack_size,
                         void* (*start_routine)(void))
{
  int                policy;
  pthread_t          tid;
  pthread_attr_t     attr;
  struct sched_param param;

  tid = (pthread_t) pthread_attr_init (&attr);
  if (tid != 0)
  {
    return tid;
  }

  tid = (pthread_t) pthread_attr_setscope (&attr, PTHREAD_SCOPE_SYSTEM);
  if (tid != 0)
  {
    return tid;
  }
  if (stack_size != 0)
  {
	tid = (pthread_t) pthread_attr_setstacksize (&attr, stack_size);
    if (tid != 0)
    {
	  return tid;
    }
  }
  pthread_create (&tid, &attr, (void* (*)(void*))start_routine, NULL);
  policy = SCHED_FIFO;
  param.sched_priority = priority;

}


static int make_periodic (struct periodic_info *info)
{
	static int next_sig;
	int ret;
	unsigned int ns;
	unsigned int sec;
	struct sigevent sigev;
	timer_t timer_id;
	struct itimerspec itval;

	/* Initialise next_sig first time through. We can't use static
	   initialisation because SIGRTMIN is a function call, not a constant */
	if (next_sig == 0)
		next_sig = SIGRTMIN;
	/* Check that we have not run out of signals */
	if (next_sig > SIGRTMAX)
		return -1;
	info->sig = next_sig;
	next_sig++;

	info->wakeups_missed = 0;

	/* Create the signal mask that will be used in wait_period */
	sigemptyset (&(info->alarm_sig));
	sigaddset (&(info->alarm_sig), info->sig);

	/* Create a timer that will generate the signal we have chosen */
	sigev.sigev_notify = SIGEV_SIGNAL;
	sigev.sigev_signo = info->sig;
	sigev.sigev_value.sival_ptr = (void *) &timer_id;
	ret = timer_create (CLOCK_MONOTONIC, &sigev, &timer_id);
	if (ret == -1)
		return ret;

	/* Make the timer periodic */
	sec = info->period/1000000;
	ns = (period - (sec * 1000000)) * 1000;
	itval.it_interval.tv_sec = sec;
	itval.it_interval.tv_nsec = ns;
	itval.it_value.tv_sec = sec;
	itval.it_value.tv_nsec = ns;
	ret = timer_settime (timer_id, 0, &itval, NULL);
	return ret;
}

static void wait_period (struct periodic_info *info)
{
	int sig;
	sigwait (&(info->alarm_sig), &sig);
        info->wakeups_missed += timer_getoverrun (info->timer_id);
}

int mask_realtime_signals()
{
	sigset_t alarm_sig;
	int i;

	/* Block all real time signals so they can be used for the timers.
	   Note: this has to be done in main() before any threads are created
	   so they all inherit the same mask. Doing it later is subject to
	   race conditions */
	sigemptyset (&alarm_sig);
	for (i = SIGRTMIN; i <= SIGRTMAX; i++)
		sigaddset (&alarm_sig, i);
	sigprocmask (SIG_BLOCK, &alarm_sig, NULL);
}
