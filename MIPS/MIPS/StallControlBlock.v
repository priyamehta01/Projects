`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:12:00 10/23/2016 
// Design Name: 
// Module Name:    StallControlBlock 
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
Member Names : Priya Mehta, Vishwa Saparia, Mohit Solanki
Date : 2.9.2016
Code Details : Understand and implement Stall Control Block.
*/

//Module Decalaration
module StallControlBlock(stall, stall_pm, clk, reset, ins_pm);

//Output Declaration
output stall, stall_pm;

//Input Declaration
input clk, reset;
input [19:0]ins_pm;

//Wire Declaration
wire jump, ld, hlt;
reg Q1, Q2, Q3, Q4;

//Assigning value to jump by anding from ins_pm bits and output of D Flip Flop
assign jump = ins_pm[19] && ins_pm[18] && ins_pm[17] && ~Q4; 

//Assigning value to load(ld) by anding from ins_pm bits and output of D Flip Flop
assign ld = ins_pm[19] && ~ins_pm[18] && ins_pm[17] && ~ins_pm[16] && ~ins_pm[15] && ~Q1;

//Assigning value to halt(hlt) by anding from ins_pm bits and output of D Flip Flop 
assign hlt = ins_pm[19] && ~ins_pm[18] && ~ins_pm[17] && ~ins_pm[16] && ins_pm[15];

//Assigning value to stall by oring jump, ld and hlt
assign stall = jump || ld || hlt;

//Assigning output of D Flip Flop to stall_pm
assign stall_pm = Q2;

//Assigning values at posedge of clock
always@(posedge clk)
begin

if(reset==1'b1)
begin
Q1 <= ld;								//Assigning Q1 value of ld
Q2 <= stall;							//Assigning Q2 value of stall
Q3 <= jump;								//Assigning Q3 value of jump
Q4 <= Q3;								//Assigning Q4 value of Q3
end

else										//Resetting values of output at reset
begin
Q1 <= 0;
Q2 <= 0;
Q3 <= 0;
Q4 <= 0;
end
end 

endmodule

