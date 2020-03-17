`timescale 1ns / 1ps
module fan(
	(* LOC = "B8" *) input sys_clk,
	(* LOC = "N17 L13 L14 K17 K18 H18 G18"*) input [6:0] sw,
	(* LOC=""*) output volts
    );

reg[7:0] count=0;

always@(posedge sys_clk) begin

		if (count==255)begin
			count<=0;
		end
		if(sw[6]==1)begin
			volts<=0;
				count<=count+1;
		end
		
		if(sw==2'b01)begin
			
		end
	end


endmodule
