`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Jimmy Hickey
// 7-segment display
//////////////////////////////////////////////////////////////////////////////////
module Luce(
	input 	[3:0]	pick_a_7seg,
	input 	[3:0]	numbers,
	output	[3:0]	enable,
	output	[6:0]	segments
  );
		select_7seg			gate0(pick_a_7seg,enable);
		display_numbah		gate1(numbers,segments);

endmodule

module select_7seg(
	input		[3:0] sw,
	output	[3:0] svn
	);
	
	//assign 7-segments to switches
	assign svn[0] = !(sw[0]&!sw[1]&!sw[2]&!sw[3]);
	assign svn[1] = !(!sw[0]&sw[1]&!sw[2]&!sw[3]);
	assign svn[2] = !(!sw[0]&!sw[1]&sw[2]&!sw[3]);
	assign svn[3] = !(!sw[0]&!sw[1]&!sw[2]&sw[3]);
endmodule

module display_numbah(
	input		[3:0]	n,
	output	[6:0] segment
);
	//wire for inputs
	wire n0=n[0];
	wire n1=n[1];
	wire n2=n[2];
	wire n3=n[3];
	
	//wires for clarity
	wire a,b,c,d,e,f,g;
	
	//move segments to letters for clarity
	assign segment[0]=a;
	assign segment[1]=b;
	assign segment[2]=c;
	assign segment[3]=d;
	assign segment[4]=e;
	assign segment[5]=f;
	assign segment[6]=g;
	
	//k-map of segments
	assign a=!(n3|n2&n0|n1|!n3&!n2&!n0);
	assign b=!(n3|!n2|n1&n0|!n1&!n0);
	assign c=!(!n1|n0|n2);
	assign d=!(n1&!n0|!n1&!n0&!n2|n1&!n3&!n2|!n1&n0&n2);
	assign e=(n0|!n1&n2);
	assign f=!(n3|!n1&!n0|n2&!n1|!n0&!n3&n2);
	assign g=!(n3|!n1&n2|n1&!n0|!n3&!n2&n1);
endmodule