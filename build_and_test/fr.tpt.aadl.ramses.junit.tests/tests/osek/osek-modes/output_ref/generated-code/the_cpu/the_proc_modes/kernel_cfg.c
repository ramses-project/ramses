/*
 *  kernel_cfg.c
 *  Mon Feb 02 14:26:28 2015
 *  SG Version 2.00
 *  sg.exe ./the_proc_modes.oil -os=ECC2 -I/opt/sandbox/nxtOSEK-ramses/ecrobot/../toppers_osek/sg/impl_oil -template=/opt/sandbox/nxtOSEK-ramses/ecrobot/../toppers_osek/sg/lego_nxt.sgt
 */
#include "osek_kernel.h"
#include "kernel_id.h"
#include "alarm.h"
#include "interrupt.h"
#include "resource.h"
#include "task.h"

#define __STK_UNIT VP
#define __TCOUNT_STK_UNIT(sz) (((sz) + sizeof(__STK_UNIT) - 1) / sizeof(__STK_UNIT))

#define TNUM_ALARM     8
#define TNUM_COUNTER   1
#define TNUM_ISR2      0
#define TNUM_RESOURCE  6
#define TNUM_TASK      6
#define TNUM_EXTTASK   3

const UINT8 tnum_alarm    = TNUM_ALARM;
const UINT8 tnum_counter  = TNUM_COUNTER;
const UINT8 tnum_isr2     = TNUM_ISR2;
const UINT8 tnum_resource = TNUM_RESOURCE;
const UINT8 tnum_task     = TNUM_TASK;
const UINT8 tnum_exttask  = TNUM_EXTTASK;

 /****** Object OS ******/

 /****** Object TASK ******/

const TaskType the_sender = 0;
const TaskType the_proc_modes_mode_m1 = 1;
const TaskType the_proc_modes_mode_m2 = 2;
const TaskType the_receiver = 3;
const TaskType the_receiver_m1 = 4;
const TaskType the_receiver_m2 = 5;

extern void TASKNAME( the_sender )( void );
extern void TASKNAME( the_proc_modes_mode_m1 )( void );
extern void TASKNAME( the_proc_modes_mode_m2 )( void );
extern void TASKNAME( the_receiver )( void );
extern void TASKNAME( the_receiver_m1 )( void );
extern void TASKNAME( the_receiver_m2 )( void );

static __STK_UNIT _stack_the_sender[__TCOUNT_STK_UNIT(512)];
static __STK_UNIT _stack_the_proc_modes_mode_m1[__TCOUNT_STK_UNIT(512)];
static __STK_UNIT _stack_the_proc_modes_mode_m2[__TCOUNT_STK_UNIT(512)];
static __STK_UNIT _stack_the_receiver[__TCOUNT_STK_UNIT(512)];
static __STK_UNIT _stack_the_receiver_m1[__TCOUNT_STK_UNIT(512)];
static __STK_UNIT _stack_the_receiver_m2[__TCOUNT_STK_UNIT(512)];

const Priority tinib_inipri[TNUM_TASK] = { TPRI_MINTASK + 10, TPRI_MINTASK + 9, TPRI_MINTASK + 9, TPRI_MINTASK + 5, TPRI_MINTASK + 5, TPRI_MINTASK + 5, };
const Priority tinib_exepri[TNUM_TASK] = { TPRI_MINTASK + 10, TPRI_MINTASK + 9, TPRI_MINTASK + 9, TPRI_MINTASK + 5, TPRI_MINTASK + 5, TPRI_MINTASK + 5, };
const UINT8 tinib_maxact[TNUM_TASK] = { (1) - 1, (1) - 1, (1) - 1, (1) - 1, (1) - 1, (1) - 1, };
const AppModeType tinib_autoact[TNUM_TASK] = { 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000, 0x00000000, };
const FP tinib_task[TNUM_TASK] = { TASKNAME( the_sender ), TASKNAME( the_proc_modes_mode_m1 ), TASKNAME( the_proc_modes_mode_m2 ), TASKNAME( the_receiver ), TASKNAME( the_receiver_m1 ), TASKNAME( the_receiver_m2 ), };
const __STK_UNIT tinib_stk[TNUM_TASK] = { (__STK_UNIT)_stack_the_sender, (__STK_UNIT)_stack_the_proc_modes_mode_m1, (__STK_UNIT)_stack_the_proc_modes_mode_m2, (__STK_UNIT)_stack_the_receiver, (__STK_UNIT)_stack_the_receiver_m1, (__STK_UNIT)_stack_the_receiver_m2, };
const UINT16 tinib_stksz[TNUM_TASK] = { 512, 512, 512, 512, 512, 512, };

TaskType tcb_next[TNUM_TASK];
UINT8 tcb_tstat[TNUM_TASK];
Priority tcb_curpri[TNUM_TASK];
UINT8 tcb_actcnt[TNUM_TASK];
EventMaskType tcb_curevt[TNUM_EXTTASK];
EventMaskType tcb_waievt[TNUM_EXTTASK];
ResourceType tcb_lastres[TNUM_TASK];
DEFINE_CTXB(TNUM_TASK);

 /****** Object COUNTER ******/

const CounterType the_cpu_SystemCounter = 0;

const TickType cntinib_maxval[TNUM_COUNTER] = { 2000, };
const TickType cntinib_maxval2[TNUM_COUNTER] = { 4001, };
const TickType cntinib_tickbase[TNUM_COUNTER] = { 1, };
const TickType cntinib_mincyc[TNUM_COUNTER] = { 1, };

AlarmType cntcb_almque[TNUM_COUNTER];
TickType cntcb_curval[TNUM_COUNTER];

 /****** Object ALARM ******/

const AlarmType wakeUpthe_sender_m1 = 0;
const AlarmType wakeUpthe_sender_m2 = 1;
const AlarmType wakeUpthe_receiver_m1 = 2;
const AlarmType wakeUpthe_receiver_m2 = 3;
const AlarmType wakeUpthe_receiver_m1_m1 = 4;
const AlarmType wakeUpthe_receiver_m2_m2 = 5;
const AlarmType wakeUpthe_proc_modes_mode_m1_m1 = 6;
const AlarmType wakeUpthe_proc_modes_mode_m2_m2 = 7;

DeclareTask(the_sender);
static void _activate_alarm_wakeUpthe_sender_m1( void );
static void _activate_alarm_wakeUpthe_sender_m1( void )
{ (void)ActivateTask( the_sender ); }

DeclareTask(the_sender);
static void _activate_alarm_wakeUpthe_sender_m2( void );
static void _activate_alarm_wakeUpthe_sender_m2( void )
{ (void)ActivateTask( the_sender ); }

DeclareTask(the_receiver);
static void _activate_alarm_wakeUpthe_receiver_m1( void );
static void _activate_alarm_wakeUpthe_receiver_m1( void )
{ (void)ActivateTask( the_receiver ); }

DeclareTask(the_receiver);
static void _activate_alarm_wakeUpthe_receiver_m2( void );
static void _activate_alarm_wakeUpthe_receiver_m2( void )
{ (void)ActivateTask( the_receiver ); }

DeclareTask(the_receiver_m1);
static void _activate_alarm_wakeUpthe_receiver_m1_m1( void );
static void _activate_alarm_wakeUpthe_receiver_m1_m1( void )
{ (void)ActivateTask( the_receiver_m1 ); }

DeclareTask(the_receiver_m2);
static void _activate_alarm_wakeUpthe_receiver_m2_m2( void );
static void _activate_alarm_wakeUpthe_receiver_m2_m2( void )
{ (void)ActivateTask( the_receiver_m2 ); }

DeclareTask(the_proc_modes_mode_m1);
static void _activate_alarm_wakeUpthe_proc_modes_mode_m1_m1( void );
static void _activate_alarm_wakeUpthe_proc_modes_mode_m1_m1( void )
{ (void)ActivateTask( the_proc_modes_mode_m1 ); }

DeclareTask(the_proc_modes_mode_m2);
static void _activate_alarm_wakeUpthe_proc_modes_mode_m2_m2( void );
static void _activate_alarm_wakeUpthe_proc_modes_mode_m2_m2( void )
{ (void)ActivateTask( the_proc_modes_mode_m2 ); }

const CounterType alminib_cntid[TNUM_ALARM] = { 0, 0, 0, 0, 0, 0, 0, 0, };
const FP alminib_cback[TNUM_ALARM] = { _activate_alarm_wakeUpthe_sender_m1, _activate_alarm_wakeUpthe_sender_m2, _activate_alarm_wakeUpthe_receiver_m1, _activate_alarm_wakeUpthe_receiver_m2, _activate_alarm_wakeUpthe_receiver_m1_m1, _activate_alarm_wakeUpthe_receiver_m2_m2, _activate_alarm_wakeUpthe_proc_modes_mode_m1_m1, _activate_alarm_wakeUpthe_proc_modes_mode_m2_m2, };
const AppModeType alminib_autosta[TNUM_ALARM] = { 0x00000001, 0x00000002, 0x00000001, 0x00000002, 0x00000001, 0x00000002, 0x00000001, 0x00000002, };
const TickType alminib_almval[TNUM_ALARM] = { 1, 1, 1, 1, 1, 1, 1, 1, };
const TickType alminib_cycle[TNUM_ALARM] = { 1000, 1000, 2000, 2000, 2000, 2000, 2000, 2000, };

AlarmType almcb_next[TNUM_ALARM];
AlarmType almcb_prev[TNUM_ALARM];
TickType almcb_almval[TNUM_ALARM];
TickType almcb_cycle[TNUM_ALARM];

 /****** Object RESOURCE ******/

const ResourceType the_proc_modes_mode_m1_globalQueue_rez = 0;
const ResourceType the_proc_modes_mode_m2_globalQueue_rez = 1;
const ResourceType the_receiver_input_data_globalVariable_m1_rez = 2;
const ResourceType the_receiver_input_data_globalVariable_m2_rez = 3;
const ResourceType the_receiver_m1_input_data_globalVariable_rez = 4;
const ResourceType the_receiver_m2_input_data_globalVariable_rez = 5;

const Priority resinib_ceilpri[TNUM_RESOURCE] = { TPRI_MINTASK + 10, TPRI_MINTASK + 10, TPRI_MINTASK + 5, TPRI_MINTASK + 5, TPRI_MINTASK + 5, TPRI_MINTASK + 5, };

Priority rescb_prevpri[TNUM_RESOURCE];
ResourceType rescb_prevres[TNUM_RESOURCE];

 /****** Object EVENT ******/

const EventMaskType the_proc_modes_mode_m1_globalQueue_evt = (1UL << 0);
const EventMaskType the_proc_modes_mode_m2_globalQueue_evt = (1UL << 1);

 /****** Object ISR ******/


#define IPL_MAXISR2 0
const IPL ipl_maxisr2 = IPL_MAXISR2;


const Priority isrinib_intpri[TNUM_ISR2+1] = { 0};
ResourceType isrcb_lastres[TNUM_ISR2+1];

 /****** Object APPMODE ******/

void object_initialize( void )
{
	alarm_initialize();
	resource_initialize();
	task_initialize();
}


/*
 *  TOPPERS/OSEK Kernel
 *      Toyohashi Open Platform for Embedded Real-Time Systems/
 *      OSEK Kernel
 * 
 *  Copyright (C) 2006 by Witz Corporation, JAPAN
 * 
 *  ��L���쌠�҂́C�ȉ��� (1)�`(4) �̏������CFree Software Foundation 
 *  �ɂ���Č��\����Ă��� GNU General Public License �� Version 2 �ɋL
 *  �q����Ă�������𖞂����ꍇ�Ɍ���C�{�\�t�g�E�F�A�i�{�\�t�g�E�F�A
 *  �����ς������̂��܂ށD�ȉ������j���g�p�E�����E���ρE�Ĕz�z�i�ȉ��C
 *  ���p�ƌĂԁj���邱�Ƃ𖳏��ŋ�������D
 *  (1) �{�\�t�g�E�F�A���\�[�X�R�[�h�̌`�ŗ��p����ꍇ�ɂ́C��L�̒���
 *      ���\���C���̗��p��������щ��L�̖��ۏ؋K�肪�C���̂܂܂̌`�Ń\�[
 *      �X�R�[�h���Ɋ܂܂�Ă��邱�ƁD
 *  (2) �{�\�t�g�E�F�A���C���C�u�����`���ȂǁC���̃\�t�g�E�F�A�J���Ɏg
 *      �p�ł���`�ōĔz�z����ꍇ�ɂ́C�Ĕz�z�ɔ����h�L�������g�i���p
 *      �҃}�j���A���Ȃǁj�ɁC��L�̒��쌠�\���C���̗��p��������щ��L
 *      �̖��ۏ؋K����f�ڂ��邱�ƁD
 *  (3) �{�\�t�g�E�F�A���C�@��ɑg�ݍ��ނȂǁC���̃\�t�g�E�F�A�J���Ɏg
 *      �p�ł��Ȃ��`�ōĔz�z����ꍇ�ɂ́C���̂����ꂩ�̏����𖞂�����
 *      �ƁD
 *    (a) �Ĕz�z�ɔ����h�L�������g�i���p�҃}�j���A���Ȃǁj�ɁC��L�̒�
 *        �쌠�\���C���̗��p��������щ��L�̖��ۏ؋K����f�ڂ��邱�ƁD
 *    (b) �Ĕz�z�̌`�Ԃ��C�ʂɒ�߂���@�ɂ���āCTOPPERS�v���W�F�N�g��
 *        �񍐂��邱�ƁD
 *  (4) �{�\�t�g�E�F�A�̗��p�ɂ�蒼�ړI�܂��͊ԐړI�ɐ����邢���Ȃ鑹
 *      �Q������C��L���쌠�҂����TOPPERS�v���W�F�N�g��Ɛӂ��邱�ƁD
 * 
 *  �{�\�t�g�E�F�A�́C���ۏ؂Œ񋟂���Ă�����̂ł���D��L���쌠�҂�
 *  ���TOPPERS�v���W�F�N�g�́C�{�\�t�g�E�F�A�Ɋւ��āC���̓K�p�\����
 *  �܂߂āC�����Ȃ�ۏ؂��s��Ȃ��D�܂��C�{�\�t�g�E�F�A�̗��p�ɂ�蒼
 *  �ړI�܂��͊ԐړI�ɐ����������Ȃ鑹�Q�Ɋւ��Ă��C���̐ӔC�𕉂�Ȃ��D
 * 
 */



