module Lukas(
	input a,
	input b,
	output m,
	output n,
	output p,
	output q
    );
	 //assign outputs
	assign m = a & b;
	assign n = a | b;
	assign p = !a;
	assign q = !a & b | a & !b;
endmodule

module implement(
	a0,a1,
	b0,b1,
	m0,m1,
	n0,n1,
	p0,p1,
	q0,q1);
	//input switches
	(* LOC="G18" *) input a0;
	(* LOC="N17" *) input a1;
	(* LOC="H18" *) input b0;
	(* LOC="R17" *) input b1;
	
	//output
	(* LOC="J14" *) output m0;
	(* LOC="J15" *) output n0;
	(* LOC="K15" *) output p0;
	(* LOC="K14" *) output q0;

	(* LOC="E17" *) output m1;
	(* LOC="P15" *) output n1;
	(* LOC="F4" *) output p1;
	(* LOC="R4" *) output q1;
	
	//implement
	Lukas gate0(a0,b0,m0,n0,p0,q0);
	Lukas gate1(a1,b1,m1,n1,p1,q1);
	
endmodule