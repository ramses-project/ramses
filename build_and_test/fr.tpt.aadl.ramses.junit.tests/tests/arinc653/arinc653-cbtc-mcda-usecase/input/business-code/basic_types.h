#ifndef _Basic_types_h_
#define _Basic_types_h_

#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <assert.h>


#ifndef __POK_C__
#include <syslog.h>
#include <stdint.h>
#include <time.h>
#include "mccm_debug.h"
#else
#include <core/time.h>
typedef uint32_t time_t;
struct timespec {
        time_t   tv_sec;        /* seconds */
        long     tv_nsec;       /* nanoseconds */
};
#define CLOCK_REALTIME 0
inline static int clock_gettime(int __attribute__((unused)) clk_id, struct timespec *tp) {
        uint32_t time;
        pok_time_gettick(&time);
        tp->tv_sec = time/1000;
        time-= tp->tv_sec*1000;
        tp->tv_nsec = time *1000000;
        return 0;
}
#define assert(X) //assert(x)

#define LOG_EMERG       0       /* system is unusable */
#define LOG_ALERT       1       /* action must be taken immediately */
#define LOG_CRIT        2       /* critical conditions */
#define LOG_ERR         3       /* error conditions */
#define LOG_WARNING     4       /* warning conditions */
#define LOG_NOTICE      5       /* normal but significant condition */
#define LOG_INFO        6       /* informational */
#define LOG_DEBUG       7       /* debug-level messages */
#define LOG_KERN        (0<<3)  /* kernel messages */
#define LOG_USER        (1<<3)  /* random user-level messages */
#define LOG_MAIL        (2<<3)  /* mail system */
#define LOG_DAEMON      (3<<3)  /* system daemons */
#define LOG_AUTH        (4<<3)  /* security/authorization messages */
#define LOG_SYSLOG      (5<<3)  /* messages generated internally by syslogd */
#define LOG_LPR         (6<<3)  /* line printer subsystem */
#define LOG_NEWS        (7<<3)  /* network news subsystem */
#define LOG_UUCP        (8<<3)  /* UUCP subsystem */
#define LOG_CRON        (9<<3)  /* clock daemon */
#define LOG_AUTHPRIV    (10<<3) /* security/authorization messages (private) */
#define LOG_FTP         (11<<3) /* ftp daemon */

extern int cycle_nb;

static inline void syslog(int  __attribute__((unused)) priority, const char *format, ...)
{
  va_list       args;

  va_start(args, format);
  if(cycle_nb<10)
	printf (format, args);
  va_end(args);
}
#endif

typedef unsigned long int ulong;
typedef unsigned long long ulonglong;
typedef unsigned short int ushort;
typedef unsigned int uint;

#endif /* _Basic_types_h_ */
