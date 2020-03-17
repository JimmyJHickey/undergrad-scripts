`timescale 1ns / 1ps
module geigerrrrrr(
	(* LOC = "B8" *) input sys_clk,
	(* LOC = "B18" *) input geiger,
	(* LOC = "D18" *) input geiger2,
	//(* LOC = "H13" *) input reset,
	(* LOC = "K18 H18 G18" *) input [2:0]sw,
	(* LOC = "R4 F4 P15 E17 K14 K15 J15 J14" *)	output reg [7:0] LED
);


reg [12:0] pulse=0;
reg [7:0] count=0;
reg [7:0] sec_count=0;
reg [7:0] min_count=0;
reg [24:0] sec_clock=0;
//counts seconds
reg [5:0] count_sec=0;

//second counter
reg [12:0] pulse2=0;
reg [7:0] count2=0;
reg [7:0] sec_count2=0;
reg [7:0] min_count2=0;


always@(posedge sys_clk)begin
	if(geiger==1 && pulse == 0) begin
		pulse<=1;
	end //geiger && pulse

	if(pulse<5000 && pulse !=0) begin
		pulse<=pulse+1;
	end //pulse<5000 && pulse!=0
	
	if(pulse == 5000) begin
		pulse<=0;
		count<=count+1;
		min_count<=min_count+1;
		sec_count<=sec_count+1;
	end //pulse == 5000

//second counter

if(geiger2==1 && pulse2 == 0) begin
		pulse2<=1;
	end //geiger && pulse

	if(pulse2<5000 && pulse2 !=0) begin
		pulse2<=pulse2+1;
	end //pulse<5000 && pulse!=0
	
	if(pulse2 == 5000) begin
		pulse2<=0;
		count2<=count2+1;
		min_count2<=min_count2+1;
		sec_count2<=sec_count2+1;
	end //pulse == 5000



//display output for one button
	if(sw == 3'b001) begin
		LED<=sec_count;
	end
	
	if(sw == 3'b010) begin
		LED<=min_count;
	end 
	
	if(sw == 3'b011) begin
		LED<=count;
	end //sw == 2'b11
	
	//output for 2 buttons
	if(sw == 3'b101) begin
		//average by adding and then shifting
		LED<=(sec_count+sec_count2)>>1;
	end
	
	if(sw == 3'b110) begin
		LED<=(min_count+min_count2)>>2;
	end 
	
	if(sw == 3'b111) begin
	end 
		LED<=(count+count2)>>2;

//clocks	
	if(sec_clock!=49_999_999)begin
		sec_clock<=sec_clock+1;
	end

	if(sec_clock==49_999_999)begin
		sec_clock<=0;
		sec_count<=0;
		sec_count2<=0;
		count_sec<=count_sec+1;
	end
	
	if(count_sec==60)begin
		count_sec<=0;
		min_count<=0;
		min_count2<=0;
	end
	
	if(reset==1) begin
		count<=0;
		count2<=0;
		min_count<=0;
		min_count2<=0;
		sec_count<=0;
		sec_count2<=0;
	end
	
end //end always

endmodule
