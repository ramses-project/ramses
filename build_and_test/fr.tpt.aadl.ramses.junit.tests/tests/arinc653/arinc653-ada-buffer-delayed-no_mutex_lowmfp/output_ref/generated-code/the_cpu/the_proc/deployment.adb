
package body Deployment is
  procedure Init_Global_Variables is
  begin
    writer_instances_the_receiver_p := (0 => (1000,1000));
    context_the_receiver_p := (200,1,2,1000,writer_instances_the_receiver_p);
  end Init_Global_Variables;
procedure Deployment is
begin
null;
end Deployment;

end Deployment;

