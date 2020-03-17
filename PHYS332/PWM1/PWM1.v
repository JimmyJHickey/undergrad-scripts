`timescale 1ns / 1ps

module PWM1(
	(* LOC = "B8" *) input sys_clk,
	(* LOC = "H18 G18"*) input [1:0] sw,
   (* LOC = "J15 J14"*) output reg [1:0] leds
    );

	reg[7:0] count=0;
	
	always@(posedge sys_clk) begin
		leds[0]<=0;
		leds[1]<=1;
		if (count==255)begin
			count<=0;
		end
		if(sw==2'b00)begin
			if(count<51) begin
				count<=count+1;
				leds[0]<=1;
				end
			else begin
				count<=count+1;
		end end
		else if(sw==2'b01)begin
			if(count<103) begin
				count<=count+1;
				leds[0]<=1;
			end
			else begin
				count<=count+1;
		end end
		else if(sw==2'b10)begin
			if(count<154) begin
				count<=count+1;
				leds[0]<=1;
			end
			else begin
				count<=count+1;
		end end
		else if(sw==2'b11)begin
		if(count<205) begin
				count<=count+1;
				leds[0]<=1;
			end
			else begin
				count<=count+1;
		end end
		else begin
			count<=count+1;
		end
	end

endmodule
