`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:46:00 10/27/2015 
// Design Name: 
// Module Name:    Counter 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module LEDclock(
	//Allocate pins from Nexys2 to names
	(* LOC="B8" *) input system_clock,
	(* LOC="R4" *) output new_clock
    );
			make_new_clock gate0(system_clock,new_clock);	
endmodule

module make_new_clock(
	input sys_clk,
	output reg clk_out
);
reg[27:0] counter=0;//28 bit

always@(posedge sys_clk) begin
	if(counter == 149_999_999) begin
		counter<=0;
		clk_out<=1;
	end else if(counter==99_999_999) begin
		clk_out<=0;
		counter<=counter+1;
	end else begin
		counter<=counter+1;
		end
end
endmodule