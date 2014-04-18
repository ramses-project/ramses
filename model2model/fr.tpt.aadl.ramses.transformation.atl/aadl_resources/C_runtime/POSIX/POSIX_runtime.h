#ifndef __POSIX_RUNTIME_H__
#define __POSIX_RUNTIME_H__

typedef struct periodic_thread_config
{
	const unsigned int period;
	int sig;
	sigset_t alarm_sig;
	int wakeups_missed;
} periodic_thread_config_t;

pthread_t create_thread (unsigned int priority,
						 unsigned int stack_size,
                         void* (*start_routine)(void));

int init_periodic_config (periodic_thread_config_t *info);

void wait_next_period (periodic_thread_config_t *info);

int mask_realtime_signals();


#endif
