`timescale 1ns / 1ps
module geiger(
	(* LOC = "B8" *) input sys_clk,
	(* LOC = "B18" *) input geiger,
	(* LOC = "H18 G18" *) input [1:0]sw
	(* LOC = "R4 F4 P15 E17 K14 K15 J15 J14" *)	output reg [7:0] LED
);


reg [12:0] pulse=0;
reg [7:0] count=0;
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
	end //pulse == 5000

	if(sw == 2'b11) begin
		
		count<=count+1;
		
		//LED<=count;
	end //sw == 2'b11
	
end //end always


endmodule
