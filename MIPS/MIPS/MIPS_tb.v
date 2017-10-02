`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   23:13:47 10/23/2016
// Design Name:   MIPS
// Module Name:   C:/Users/VISHWA/Desktop/Sem 3/CO_Lab/MIPS/MIPS_tb.v
// Project Name:  MIPS
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: MIPS
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module MIPS_tb;

	// Inputs
	reg clk;
	reg interrupt;
	reg reset;
	reg [7:0] data_in;

	// Outputs
	wire [7:0] data_out;
	wire [19:0] ins;
	wire [7:0] A;
	wire [7:0] B;
	wire [7:0] current_address;
	wire [7:0] ans_ex;
	wire [7:0] mux_ans_dm;
	wire [7:0] ans_wb;

	// Instantiate the Unit Under Test (UUT)
	MIPS uut (
		.data_out(data_out), 
		.ins(ins), 
		.A(A), 
		.B(B), 
		.current_address(current_address), 
		.ans_ex(ans_ex), 
		.mux_ans_dm(mux_ans_dm), 
		.ans_wb(ans_wb), 
		.clk(clk), 
		.interrupt(interrupt), 
		.reset(reset), 
		.data_in(data_in)
	);

	initial
	begin
	data_in = 0;
	interrupt = 0;
	clk = 0;
	reset = 1;
	#200; reset = 0;
	#500; reset = 1;
	end
	always
	#500 clk = ~clk;

      
endmodule

