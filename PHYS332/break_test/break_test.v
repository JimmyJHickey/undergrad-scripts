`timescale 1ns / 1ps
module break_test(
(* LOC = "'*B8" *) input sys_clk,
(* LOC = "G18"*) input sw,
(*LOC="J14"*) output reg LED
    );
always@(posedge sys_clk)begin
LED<=1;

break;

end

endmodule