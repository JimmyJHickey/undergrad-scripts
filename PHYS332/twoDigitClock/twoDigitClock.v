`timescale 1ns / 1ps

module twoDigitClock(
	(* LOC = "B8" *) input sys_clk,
	(* LOC = "L14 K17 K18 H18 G18"*) input [4:0] sw,
	(* LOC = "F15 C18 H17 F17"*) output reg [3:0] seg,
   (* LOC = "C17 H14 J17 G14 D16 D17 F18 L18"*) output reg [7:0] segments
    );

	reg[10:0] count=0;
	
	always@(posedge sys_clk) begin
		seg[3:0]<=4'b1111;
		segments[7:0]<=8'b11111111;
		if (count==1023)begin
			count<=0;
		end
		
		//Ones Digit
		if(count<512)begin
			seg[0]<=0;
			segments[0]<= (!sw[4]&!sw[3]&!sw[2]&!sw[1]&sw[0] 	| !sw[4]&!sw[3]&sw[2]&!sw[1]&!sw[0] | !sw[4]&sw[3]&!sw[2]&sw[1]&sw[0]	| 
								!sw[4]&sw[3]&sw[2]&sw[1]&!sw[0]		| sw[4]&sw[3]&!sw[2]&!sw[1]&!sw[0]	| sw[4]&sw[3]&sw[2]&sw[1]&sw[0]	| 
								sw[4]&!sw[3]&sw[2]&!sw[1]&sw[0]);
			segments[1]<= (!sw[4]&!sw[3]&sw[2]&sw[1]&!sw[0]		| !sw[4]&!sw[3]&sw[2]&!sw[1]&sw[0]	| !sw[4]&sw[3]&sw[2]&sw[1]&sw[0]		|
								sw[4]&sw[3]&!sw[2]&!sw[1]&sw[0]		| sw[4]&sw[3]&!sw[2]&sw[1]&!sw[0]	| sw[4]&!sw[3]&!sw[2]&!sw[1]&!sw[0]);
			segments[2]<= (!sw[4]&!sw[3]&!sw[2]&sw[1]&!sw[0]	| !sw[4]&sw[3]&sw[2]&!sw[1]&!sw[0]	| sw[4]&!sw[3]&sw[2]&sw[1]&!sw[0]);
			segments[3]<=!(!sw[4]&!sw[3]&!sw[2]&!sw[1]&!sw[0]	| !sw[4]&!sw[3]&!sw[2]&sw[1]&sw[0]	| !sw[4]&!sw[3]&!sw[2]&sw[1]&!sw[0]	|
								!sw[4]&!sw[3]&sw[2]&sw[1]&!sw[0]		| !sw[4]&!sw[3]&sw[2]&!sw[1]&sw[0] 	| !sw[4]&sw[3]&!sw[2]&!sw[1]&!sw[0]	|
								!sw[4]&sw[3]&!sw[2]&sw[1]&!sw[0]		| !sw[4]&sw[3]&sw[2]&sw[1]&sw[0]		| !sw[4]&sw[3]&sw[2]&!sw[1]&sw[0]	|
								!sw[4]&sw[3]&sw[2]&!sw[1]&!sw[0]		| sw[4]&sw[3]&!sw[2]&!sw[1]&sw[0]	| sw[4]&sw[3]&!sw[2]&sw[1]&!sw[0]	|
								sw[4]&sw[3]&sw[2]&sw[1]&!sw[0]		| sw[4]&sw[3]&sw[2]&!sw[1]&!sw[0]	| sw[4]&!sw[3]&!sw[2]&!sw[1]&!sw[0]	|
								sw[4]&!sw[3]&!sw[2]&sw[1]&!sw[0]		| sw[4]&!sw[3]&sw[2]&sw[1]&!sw[0]	| sw[4]&!sw[3]&sw[2]&sw[1]&sw[0]		|
								sw[4]&!sw[3]&sw[2]&!sw[1]&!sw[0]);
			segments[4]<= (!sw[2]&sw[0]								| sw[2]&sw[0]								| sw[4]&sw[3]&!sw[2]&!sw[1]			|
								!sw[4]&!sw[3]&sw[2]&!sw[1]				| !sw[4]&sw[3]&sw[2]&sw[1]);
			segments[5]<=!(!sw[2]&!sw[1]&!sw[0]						| sw[3]&!sw[2]&!sw[1]					| sw[3]&sw[1]&!sw[0]						|
								sw[4]&!sw[2]&sw[1]&!sw[0]				| !sw[4]&sw[2]&sw[1]&!sw[0]			| !sw[4]&sw[3]&sw[2]&sw[1]				|
								!sw[4]&!sw[3]&sw[2]&!sw[1]				| sw[4]&sw[3]&sw[2]&!sw[1]				| sw[4]&sw[2]&!sw[1]&!sw[0]			|
								sw[4]&!sw[3]&!sw[2]&sw[1]);
			segments[6]<= (!sw[4]&!sw[3]&!sw[2]&!sw[1]			| !sw[4]&sw[3]&!sw[2]&sw[1]			| sw[3]&!sw[2]&sw[1]&sw[0]				|
								sw[4]&!sw[3]&!sw[2]&!sw[1]&sw[0]		| !sw[4]&!sw[3]&sw[2]&sw[1]&sw[0]	| sw[4]&sw[3]&sw[2]&sw[1]				|
								sw[4]&!sw[3]&sw[2]&!sw[1]);
			
			count<=count+1;
		end
		
		//Tens Digit
		else if (count>=512) begin
			seg[1]<=0;
			segments[0]<=!(!sw[4]&!sw[3] 	| sw[4]&sw[3] 		| sw[4]&sw[2] 			| sw[3]&!sw[2]&!sw[1]);
			segments[1]<=0;
			segments[2]<=!(!sw[4]			| !sw[3]&!sw[2]	| sw[3]&sw[2]&sw[1]);
			segments[3]<=!(!sw[4]&!sw[3] 	| sw[4]&sw[3] 		| sw[4]&sw[2] 			| sw[3]&!sw[2]&!sw[1]);
			segments[4]<=!(!sw[4]&!sw[3] 	| !sw[3]&sw[2] 	| sw[4]&sw[2]&!sw[1] | sw[4]&sw[3]&!sw[2] 	| sw[3]&!sw[2]&!sw[1]);
			segments[5]<=!(!sw[4]&!sw[3] 	| !sw[4]&!sw[2]&!sw[1]);
			segments[6]<=!(sw[4]&sw[3] 	| sw[4]&sw[2]);
			
			count<=count+1;
		end
		
		else begin
			count<=count+1;
		end
	end

endmodule
