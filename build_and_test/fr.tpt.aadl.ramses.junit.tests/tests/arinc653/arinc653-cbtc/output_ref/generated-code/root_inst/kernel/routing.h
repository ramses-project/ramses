#ifndef __GENERATED_ROUTING_H__
#define __GENERATED_ROUTING_H__
#define POK_CONFIG_NB_GLOBAL_PORTS 8
#define POK_CONFIG_NB_PORTS 8
#define POK_CONFIG_NB_NODES 1
#define POK_CONFIG_PARTITIONS_PORTS {0,0,0,0,1,1,1,1,}
typedef enum
{
  root_inst = 0,
} pok_node_identifier_t;
typedef enum
{
  train_inst_TrainSpeedAccelCompute_inst_eoaIn = 0,
  train_inst_TrainSpeedAccelCompute_inst_trainPositionForMauOut = 1,
  train_inst_trainPpu_inst_trainDataOut = 2,
  train_inst_trainPpu_inst_trainDataIn = 3,
  railway_inst_EoaSending_inst_eoaForVobcOut = 4,
  railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauIn = 5,
  railway_inst_TrainSimu_inst_trainDataIn = 6,
  railway_inst_TrainSimu_inst_trainDataOut = 7,
  invalid_local_port = 8
} pok_port_local_identifier_t;
typedef enum
{
  train_inst_TrainSpeedAccelCompute_inst_eoaIn_TrainSpeedAccelCompute_inst_eoaIn_global = 0,
  train_inst_TrainSpeedAccelCompute_inst_trainPositionForMauOut_TrainSpeedAccelCompute_inst_trainPositionForMauOut_global = 1,
  train_inst_trainPpu_inst_trainDataOut_trainPpu_inst_trainDataOut_global = 2,
  train_inst_trainPpu_inst_trainDataIn_trainPpu_inst_trainDataIn_global = 3,
  railway_inst_EoaSending_inst_eoaForVobcOut_EoaSending_inst_eoaForVobcOut_global = 4,
  railway_inst_TrainPositionsCorrelation_inst_trainPositionVobcForMauIn_TrainPositionsCorrelation_inst_trainPositionVobcForMauIn_global = 5,
  railway_inst_TrainSimu_inst_trainDataIn_TrainSimu_inst_trainDataIn_global = 6,
  railway_inst_TrainSimu_inst_trainDataOut_TrainSimu_inst_trainDataOut_global = 7,
} pok_port_identifier_t;
typedef enum
{
  invalid_bus = 0
} pok_bus_identifier_t;
#endif
