`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:08:41 10/23/2016 
// Design Name: 
// Module Name:    MIPS 
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
module MIPS(data_out, ins, A, B, current_address, ans_ex, mux_ans_dm, ans_wb, clk, interrupt, reset, data_in);

output [19:0]ins;
output [7:0]A, B, current_address, ans_ex, mux_ans_dm, ans_wb, data_out;

input [7:0]data_in;
input clk, interrupt, reset;

wire imm_sel, mem_en_dec, mem_rw_dec, mem_mux_sel_dec;
wire [1:0] mux_sel_a,mux_sel_b;
wire [7:0] imm;
wire [4:0] RW_dec, Op_dec;

wire stall, stall_pm;
wire [19:0]ins_pm;
								
wire [7:0] jmp_loc;													
wire pc_mux_sel;

//wire interrupt;
wire [3:0]flag_ex;

wire [7:0]B_Bypass;
wire [4:0]RW_ex;
wire mem_en_ex, mem_rw_ex, mem_mux_sel_ex;

wire [4:0]RW_dm;


DependencyCheckBlock m1 (mux_sel_a, mux_sel_b, imm_sel, imm, mem_en_dec, mem_rw_dec, mem_mux_sel_dec, RW_dec, Op_dec, ins, clk, reset);

StallControlBlock m5 (stall, stall_pm, clk, reset, ins_pm);

IP_IM m2 (ins, ins_pm, current_address, jmp_loc, pc_mux_sel, stall, stall_pm, reset, clk);	

JumpControl_block m3 (pc_mux_sel, jmp_loc, ins, clk, interrupt, current_address, flag_ex, reset);

execution_block m8 (flag_ex, ans_ex, data_out, B_Bypass, mem_en_ex, mem_rw_ex, mem_mux_sel_ex, RW_ex, A, B, data_in, Op_dec, clk, mem_en_dec, mem_rw_dec, mem_mux_sel_dec, RW_dec, reset);			//Module 

RegBank m4 (A, B, ins, RW_dm, ans_ex, mux_ans_dm, ans_wb, imm, mux_sel_a, mux_sel_b, imm_sel, clk, reset);

data_memory m7 (RW_dm, mux_ans_dm, ans_ex, B_Bypass, RW_ex, mem_en_ex, mem_rw_ex, mem_mux_sel_ex, clk, reset);

WriteBack m6 (ans_wb, mux_ans_dm, reset, clk);


endmodule
