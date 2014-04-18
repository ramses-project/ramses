#ifndef _cbtc_cbtc_subsystem_DataType_module_h_
#define _cbtc_cbtc_subsystem_DataType_module_h_

/*  Description of package DataType */
/**
 * @addtogroup DataType
 * @{
 * TODO: DataType description.
 *
 * @}
 */




/* ------------------------- struct TrainData  ------------------------------- */
/**
 * @struct TrainData
 * @brief TODO: TrainData description.
 */
typedef struct 
{
/**
 * @brief TODO: source_ident description.
 * @public
 */
ulong source_ident;
/**
 * @brief TODO: destination_ident description.
 * @public
 */
ulong destination_ident;
/**
 * @brief TODO: computing_element description.
 * @public
 */
long computing_element;
/**
 * @brief TODO: msg_cycle description.
 * @public
 */
long msg_cycle;
/**
 * @brief TODO: direction description.
 * @public
 */
ulong direction;
/**
 * @brief TODO: acceleration description.
 * @public
 */
long acceleration;
/**
 * @brief TODO: limit_position description.
 * @public
 */
long limit_position;
/**
 * @brief TODO: maxi_speed description.
 * @public
 */
long maxi_speed;
/**
 * @brief TODO: speed description.
 * @public
 */
long speed;
/**
 * @brief TODO: distance_m description.
 * @public
 */
long distance_m;
/**
 * @brief TODO: distance_mm description.
 * @public
 */
long distance_mm;
/**
 * @brief TODO: sim_ctrl_1 description.
 * @public
 */
long sim_ctrl_1;
/**
 * @brief TODO: sim_ctrl_2 description.
 * @public
 */
long sim_ctrl_2;
/**
 * @brief TODO: sim_ctrl_3 description.
 * @public
 */
long sim_ctrl_3;
/**
 * @brief TODO: sim_ctrl_4 description.
 * @public
 */
long sim_ctrl_4;
} TrainData;

/* WARNING: we suppose here that all workstations have the same byte order */
#define brevTrainData_size_ brevDummyUserType_size_
/*
inline void brevTrainData_size_(int* data, int items)
{
  (void)data; // to avoid unused parameter warnings
  (void)items;
  return;
}*/

/** @} */



#endif /* __cbtc_cbtc_subsystem_DataType_module_h_ */
