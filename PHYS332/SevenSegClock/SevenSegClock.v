`timescale 1ns / 1ps
module sevenSegClock(
	//Allocate pins from Nexys2 to names
	(* LOC="B8" *) input sys_clk,
	(* LOC=" H14 J17 G14 D16 D17 F18 L18" *)output reg [6:0]segments,
	(* LOC="F15 C18 H17 F17" *)				output reg [3:0] seven_segs
	
    );
	
			//make_new_clock gate0(system_clock,nums,seven);		
//endmodule

/*module make_new_clock(
	input sys_clk,
	output reg [6:0]segments=0,
	output reg [3:0]seven_segs=0
);*/
reg[25:0]	counter=0;//26 bits to fit 50Mhz

always@(posedge sys_clk) begin
	if (counter[25]==1) begin
		counter<=0;
	end
	else if(counter[10]==1) begin
		counter<=counter+1;
		seven_segs[2:0]<=3'b111;
		seven_segs[3]<=0;
		segments[0]<=1;
		segments[2:1]<=2'b00;
		segments[6:3]<=4'b1111;
	end
	else if(counter[11]==1) begin
		counter<=counter+1;
		seven_segs[1:0]<=2'b11;
		seven_segs[2]<=0;
		seven_segs[3]<=1;
		segments[1:0]<=2'b00;
		segments[2]<=1;
		segments[4:3]<=2'b00;
		segments[5]<=1;
		segments[6]<=0;

	end
	else if(counter[12]==1) begin
		counter<=counter+1;
		seven_segs[0]<=1;
		seven_segs[1]<=0;
		seven_segs[3:2]<=2'b11;
		segments[3:0]<=4'b0000;
		segments[5:4]<=2'b11;
		segments[6]<=0;
	end
	else if(counter[13]==1) begin
		counter<=counter+1;
		seven_segs[3:1]<=3'b111;
		seven_segs[0]<=0;
		segments[0]<=1;
		segments[2:1]<=0;
		segments[4:3]<=2'b11;
		segments[6:5]<=2'b00;
	end
	else
		counter<=counter+1;
end
endmodule