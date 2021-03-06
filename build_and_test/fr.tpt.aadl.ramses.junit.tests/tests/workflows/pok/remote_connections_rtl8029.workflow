<?xml version="1.0" encoding="ASCII"?>
<rwf:Workflow xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:rwf="http://fr.tpt.aadl.ramses.control.workflow/Ramses/1.0">
  <element xsi:type="rwf:Transformation" inputModelIdentifier="//@inputModelIdentifier" identifier="network">
    <element xsi:type="rwf:Transformation" inputModelIdentifier="//@element/@outputModelIdentifier" identifier="pok">
      <element xsi:type="rwf:Generation" inputModelIdentifier="//@element/@element/@outputModelIdentifier"/>
      <list>
        <file path="ACG/targets/shared/UninstanciateOverride"/>
        <file path="ACG/targets/shared/SubprogramCallsCommonRefinementSteps"/>
        <file path="ACG/targets/shared/PortsCommonRefinementSteps"/>
        <file path="ACG/targets/shared/DispatchCommonRefinementSteps"/>
        <file path="ACG/targets/shared/BehaviorAnnexCommonRefinementSteps"/>
        <file path="ACG/targets/arinc653/ExpandThreadsDispatchProtocol"/>
        <file path="ACG/targets/arinc653/ExpandThreadsPorts"/>
        <file path="ACG/targets/arinc653/BlackboardCommunications"/>
        <file path="ACG/targets/arinc653/BufferCommunications"/>
        <file path="ACG/targets/arinc653/EventsCommunications"/>
        <file path="ACG/targets/arinc653/QueuingCommunications"/>
        <file path="ACG/targets/arinc653/SamplingCommunications"/>
        <file path="ACG/PeriodicDelayedCommunication/SharedRules"/>
        <file path="ACG/PeriodicDelayedCommunication/SharedRules_No_Mutex"/>
        <file path="ACG/PeriodicDelayedCommunication/EventDataPorts_LowMFP"/>
        <file path="helpers/LanguageSpecificitiesC"/>
      </list>
      <outputModelIdentifier id="refined_model"/>
    </element>
    <list>
      <file path="ACG/targets/shared/UninstanciateOverrideForRemoteConnections"/>
      <file path="ACG/targets/shared/RemoteConnectionsCommonRefinementSteps"/>
      <file path="ACG/targets/arinc653/RemoteConnectionsCommonRefinementSteps"/>
      <file path="ACG/targets/pok/rtl8029_driver"/>
      <file path="helpers/LanguageSpecificitiesC"/>
    </list>
    <outputModelIdentifier id="remote_communications"/>
  </element>
  <inputModelIdentifier id="input_model"/>
</rwf:Workflow>
