<?xml version="1.0" encoding="UTF-8"?>
<rwf:Workflow xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:rwf="http://fr.tpt.aadl.ramses.control.workflow/Ramses/1.0">
  <element xsi:type="rwf:Loop" inputModelIdentifier="//@inputModelIdentifier" resolutionMethod="McdaMerge" maxNbIteration="10">
    <!-- In OSATE:
    <alternatives href="platform:/resource/test_mcda/PeriodicDelayed_ARINC653_C.trc#//@transformationList/@transformations.0"/>
    <alternatives href="platform:/resource/test_mcda/PeriodicDelayed_ARINC653_C.trc#//@transformationList/@transformations.2"/>
    <alternatives href="platform:/resource/test_mcda/PeriodicDelayed_ARINC653_C.trc#//@transformationList/@transformations.1"/>
    -->
    <!-- In CLI: -->
    <alternatives href="tests/arinc653/arinc653-selection-sensitivity/input/PeriodicDelayed_ARINC653_C.trc#//@transformationList/@transformations.0"/>
    <alternatives href="tests/arinc653/arinc653-selection-sensitivity/input/PeriodicDelayed_ARINC653_C.trc#//@transformationList/@transformations.2"/>
    <alternatives href="tests/arinc653/arinc653-selection-sensitivity/input/PeriodicDelayed_ARINC653_C.trc#//@transformationList/@transformations.1"/>
    <analysis xsi:type="rwf:Conjunction">
      <!-- Need new version of AADL Inspector
      <list xsi:type="rwf:Analysis" inputModelIdentifier="//@element/@outputModelIdentifier" method="AADLInspector-SchedulingAnalysis" mode="automatic">
        <outputModelIdentifier id="wcet_model"/>
      </list>
      -->
      <list xsi:type="rwf:Analysis" inputModelIdentifier="//@element/@outputModelIdentifier" method="RAMSES-MemoryFootprintAnalysis" mode="automatic"/>
      <list xsi:type="rwf:Analysis" inputModelIdentifier="//@element/@outputModelIdentifier" method="RAMSES-MaintainabilityAnalysis" mode="automatic"/>
    </analysis>
    <outputModelIdentifier id="refined_model"/>
    <foundOption>
      <element xsi:type="rwf:Generation" inputModelIdentifier="//@element/@outputModelIdentifier"/>
    </foundOption>
    <notFoundOption>
      <element xsi:type="rwf:ErrorState"/>
    </notFoundOption>
  </element>
  <inputModelIdentifier id="input_model"/>
</rwf:Workflow>
