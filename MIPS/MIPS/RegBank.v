`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:43:35 10/23/2016 
// Design Name: 
// Module Name:    RegBank 
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
/*
Group name : B02
Member Names : Priya Mehta, Vishwa Saparia
Date : 31.8.2016
Code Details : Understand and implement Register Bank of a microprocessor.
*/

//Module Declaration
module RegBank(A, B, ins, RW_dm, ans_ex, mux_ans_dm, ans_wb, imm, mux_sel_A, mux_sel_B, imm_sel, clk, reset);

//Output Declaration
output [7:0]A, B;

//Input Declaration
input [19:0]ins;
input [7:0]ans_ex, mux_ans_dm, ans_wb, imm;
input [4:0]RW_dm;
input [1:0]mux_sel_A, mux_sel_B;
input imm_sel, clk, reset;

//Wire Declaration
reg [7:0] membyte[0:31];
reg [7:0]reg_A, reg_B;
wire [7:0]reg_temp_A, reg_temp_B;
wire [7:0]temp_B;

//Initialising data of memory block
initial begin
membyte[0] = 8'b00000000;
membyte[1] = 8'b00000001;
membyte[2] = 8'b00000010;
membyte[3] = 8'b00000011;
membyte[4] = 8'b00000100;
membyte[5] = 8'b00000101;
membyte[6] = 8'b00000110;
membyte[7] = 8'b00000111;
membyte[8] = 8'b00001000;
membyte[9] = 8'b00001001;
membyte[10] = 8'b00001010;
membyte[11] = 8'b00001011;
membyte[12] = 8'b00001100;
membyte[13] = 8'b00001101;
membyte[14] = 8'b00001110;
membyte[15] = 8'b00001111;
membyte[16] = 8'b00010000;
membyte[17] = 8'b00010001;
membyte[18] = 8'b00010010;
membyte[19] = 8'b00010011;
membyte[20] = 8'b00010100;
membyte[21] = 8'b00010101;
membyte[22] = 8'b00010110;
membyte[23] = 8'b00010111;
membyte[24] = 8'b00011000;
membyte[25] = 8'b00011001;
membyte[26] = 8'b00011010;
membyte[27] = 8'b00011011;
membyte[28] = 8'b00011100;
membyte[29] = 8'b00011101;
membyte[30] = 8'b00011110;
membyte[31] = 8'b00011111;
end

//Assigning values at appropriate reset condition
assign reg_temp_A = reset==1 ? membyte[ins[9:5]] : 8'b0;
assign reg_temp_B = reset==1 ? membyte[ins[4:0]] : 8'b0;

//Assigning values at posedge of clock	
always@(posedge clk)
begin
	
	reg_A = reg_temp_A;							//Assigning value of reg_temp_A to reg_A
	reg_B = reg_temp_B;							//Assigning value of reg_temp_B to reg_B
	membyte[RW_dm] = mux_ans_dm;				//Assigning value of mux_ans_dm to membyte[RW_dm]
end


//Assigning values through muxes
assign A = mux_sel_A == 2'b00 ? reg_A : 
          (mux_sel_A == 2'b01 ? ans_ex :
			 (mux_sel_A == 2'b10 ? mux_ans_dm : ans_wb)) ;
assign temp_B = mux_sel_B == 2'b00 ? reg_B : (mux_sel_B == 2'b01 ?ans_ex  : (mux_sel_B == 2'b10 ? mux_ans_dm : ans_wb )) ;
assign B = imm_sel == 0 ? temp_B : imm;

endmodule

