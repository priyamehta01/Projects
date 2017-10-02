`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    23:12:36 10/23/2016 
// Design Name: 
// Module Name:    WriteBack 
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
module WriteBack(ans_wb, mux_ans_dm, reset, clk);

output reg [7:0]ans_wb;

input [7:0]mux_ans_dm;
input clk, reset;

wire [7:0]mux_ans_dm_temp;

assign mux_ans_dm_temp = reset == 1'b1 ? mux_ans_dm : 8'b00000000;

always @(posedge clk)
begin
ans_wb = mux_ans_dm_temp;
end


endmodule
