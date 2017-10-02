`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:28:04 10/23/2016 
// Design Name: 
// Module Name:    data_memory 
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
Code Details : Understand and implement Data memory blocks of a microprocessor.
*/

//Module Declaration
module data_memory(RW_dm, mux_ans_dm, ans_ex, B_Bypass, RW_ex, mem_en_ex, mem_rw_ex, mem_mux_sel_ex, clk, reset);

//Output Declaration
output [7:0]mux_ans_dm;
output reg [4:0]RW_dm;

//Input Declaration
input [7:0]ans_ex, B_Bypass;
input [4:0]RW_ex;
input mem_en_ex, mem_rw_ex, clk, reset, mem_mux_sel_ex;

//Wire Declaration
reg mem_mux_sel_dm;
reg [7:0]ans_reg;
wire [7:0] ans_dm;

//Instance of IP_Core
IP_data_memory dm (
  .clka(clk), // input clk
  .ena(mem_en_ex), // input mem_en_ex
  .wea(mem_rw_ex), // input [0 : 0] mem_rw_ex
  .addra(ans_ex), // input [7 : 0] ans_ex
  .dina(B_Bypass), // input [7 : 0] B_Bypass
  .douta(ans_dm) // output [7 : 0] ans_dm
);

//Register block
always@(posedge clk)

//Assigning values at posedge of clock	
begin
if(reset == 1'b1)
begin
RW_dm = RW_ex;										//Input RW_ex in RW_dm
mem_mux_sel_dm = mem_mux_sel_ex;				//Input mem_mux_sel_ex in mem_mux_sel_dm
ans_reg = ans_ex;									//Input ans_ex in ans_reg
end

else													//Resetting values of output at reset
begin
RW_dm = 0;
mem_mux_sel_dm = 0;
ans_reg = 0;
end

end 

//Assigning values through mux

//Using mem_mux_sel_dm current_address is assigned value ans_dm(1) or ans_reg(0)
assign mux_ans_dm = mem_mux_sel_dm==1'b1 ? ans_dm : ans_reg ;			


endmodule
