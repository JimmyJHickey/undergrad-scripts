`timescale 1ns / 1ps

module PWM_Fan(
	(* LOC = "B8" *) input sys_clk,
	(* LOC = "R17 N17 L13 L14 K17 K18 H18 G18"*) input [7:0] sw,
   (* LOC = "L15"*) output reg fan
    );

	reg[25:0] count=0;
	
	always@(posedge sys_clk) begin
		fan<=0;
		if (count==49999999)begin
			count<=0;
		end
		if(sw[7]==0)begin
				fan<=0;
				count<=count+1;
				end
		if(sw==8'b10000000)begin
			//On 100% of the time
			count<=count+1;
			//Turn Fan On
			fan<=1;
		end
				
		else if(sw==8'b11000000)begin
			if(count< 45000000) begin
				//On 90% of the time
				count<=count+1;
				//Turn Fan On
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		else if(sw==8'b10100000)begin
			if(count<37500000) begin
				///On 75% of the time
				count<=count+1;
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		
		else if(sw==8'b10010000)begin
		if(count<33500000) begin
				//On 67% of the time
				count<=count+1;
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		
		else if(sw==8'b10001000)begin
		if(count<25000000) begin
				//On 50% of the time
				count<=count+1;
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		
		else if(sw==8'b10000100)begin
		if(count<12500000) begin
				//On 25% of the time
				count<=count+1;
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		
		else if(sw==8'b10000010)begin
		if(count<5000000) begin
				//On 10% of the time
				count<=count+1;
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		
		else if(sw==8'b10000001)begin
		if(count<2500000) begin
				//On 5% of the time
				count<=count+1;
				fan<=1;
			end
			else begin
				count<=count+1;
		end end
		else begin
			count<=count+1;
		end
	end

endmodule
