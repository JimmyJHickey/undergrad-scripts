module garage_door(

	(* LOC = "B8" *) input sys_clk,
	(* LOC = "G18" *) input safety,
	(* LOC = "H13" *) input button,
	(* LOC = "K15 J15 J14" *) output reg [2:0]LEDs
    );
	 reg moving=0;
	 reg on_off=0;
	 reg [25:0] change=0;
	 reg [25:0] change2=0;
always@(posedge sys_clk) begin
	if(safety==0) begin
		
		if (button==1) begin
			change<=1;
			LEDs[2]<=0;
		end
		
		if(change<49_999_999 && change!=0)begin
		change<=change+1;
		LEDs[2]<=1;
		LEDs[1:0]<=2'b00;
		moving<=1;
		end
		
		if(change==49_999_999) begin
			moving<=0;
			//Thank you for the help Lukas =]
			if(on_off==1) begin
				LEDs[1]<=0;
				LEDs[0]<=1;
				change<=0;
				LEDs[2]<=0;
				on_off<=0;
			end
			else begin
				LEDs[1]<=1;
				LEDs[0]<=0;
				change<=0;
				LEDs[2]<=0;
				on_off<=1;
			end
			
		end
		
	end
	
	else begin
	change<=0;
	
	if(moving==1)begin
		change2<=1;
		moving<=0;
	end
	
	if(change2<49_999_999 && change2!=0)begin
		change2<=change2+1;
		LEDs[2]<=1;
		LEDs[1:0]<=2'b00;
		end
		
		if(change2==49_999_999) begin
				
				LEDs[1]<=1;
				LEDs[0]<=0;
				change2<=0;
				LEDs[2]<=0;
				on_off<=1;
				change2<=0;
			end	
	end

end
	 
endmodule