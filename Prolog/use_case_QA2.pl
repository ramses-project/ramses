/*
  Example of initialization, to be generated from TRC,
  pattern matching
  and other Java components

*/
:-use_module(solutions_helpers).
:-use_module(use_case_implications).

%model_elements([cnx1, cnx2, cnx3, p11, p12, p21, p22, p31, p32]).
model_elements([1, 2, 3, 11, 12, 21, 22, 31, 32]).
transfo_rules([t1,t2,t11,t12,t21,t22]).	

canApply(1, t1).
canApply(2, t1).
canApply(3, t1).

canApply(21, t21).
canApply(31, t21).
canApply(11, t21).

canApply(22, t22).
canApply(32, t22).
canApply(12, t22).

