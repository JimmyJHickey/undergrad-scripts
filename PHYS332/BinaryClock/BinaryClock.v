`timescale 1ns / 1ps

module BinaryClock(
	//Allocate pins from Nexys2 to names
	(* LOC="B8" *) input system_clock,
	(* LOC="R4 F4 P15 E17 K14 K15 J15 J14"*)	output [7:0] bits
    );
	
			make_new_clock gate0(system_clock,bits);		
endmodule

module make_new_clock(
	input sys_clk,
	output reg [7:0]bits=0
);
reg[25:0]	counter=0;//26 bits to fit 50Mhz

always@(posedge sys_clk) begin
	if(counter == 49_999_999) begin
		counter<=0;
		bits<=bits+1;
	end else begin
		counter<=counter+1;
	end
	if(bits == 255) begin
		bits<=0;
	end
		
end
endmodule