
#ifndef _CBTC_GUI_H_
#define _CBTC_GUI_H_

#ifdef __cplusplus
extern "C" {
#endif

#ifdef USE_CBTC_GUI

  typedef void (*set_ppu_state_ptr) (int,bool);
  typedef void (*set_speed_ptr) (int);
  typedef void (*set_maxi_speed_ptr) (int);
  typedef void (*set_distance_ptr) (int);
  typedef void (*set_end_of_author_ptr) (int);
  typedef void (*set_acceleration_ptr) (int);
  typedef void (*set_braking_ptr) (int);
  typedef void (*set_progress_ptr)(void);
  typedef bool (*has_train_started_ptr)(void);
  typedef int32_t (*get_sim_control_ptr)(int);

  typedef struct
  {
    set_ppu_state_ptr       set_ppu_state;
    set_speed_ptr           set_speed;
    set_maxi_speed_ptr      set_maxi_speed;
    set_distance_ptr        set_distance;
    set_end_of_author_ptr   set_end_of_author;
    set_acceleration_ptr    set_acceleration;
    set_braking_ptr         set_braking;
    set_progress_ptr        set_progress;
    has_train_started_ptr   has_train_started;
    get_sim_control_ptr     get_sim_control;
  } cbtc_gui_t;

  typedef cbtc_gui_t* cbtc_gui_ptr;

  extern cbtc_gui_t cbtc_gui;

  cbtc_gui_ptr cbtc_gui_launch(int argc, char* argv[]);

  void cbtc_gui_set_ppu_state (int ppu_index, bool state);
  void cbtc_gui_set_speed (int speed);
  void cbtc_gui_set_maxi_speed (int maxi_speed);
  void cbtc_gui_set_distance (int distance);  
  void cbtc_gui_set_end_of_author (int eoa);  
  void cbtc_gui_set_acceleration (int acceleration);
  void cbtc_gui_set_braking (int braking);
  void cbtc_gui_set_progress();
  bool cbtc_gui_has_train_started();
  int32_t cbtc_gui_get_sim_control(int index);

#endif

#ifdef __cplusplus
}
#endif

#endif
