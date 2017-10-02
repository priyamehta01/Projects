`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:37:18 10/23/2016 
// Design Name: 
// Module Name:    JumpControl_block 
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
Date : 16.9.2016
Code Details : Understand and implement Jump Control Block.
*/

//Module Decalaration
module JumpControl_block(pc_mux_sel, jmp_loc, ins, clk, interrupt, current_address, flag_ex, reset);

//Output Declaration
output pc_mux_sel;
output [7:0]jmp_loc;

//Input Declaration
input clk, interrupt, reset;
input [19:0]ins;
input [7:0]current_address;
input [3:0]flag_ex;

//Wire Declaration
wire JC, JNC, JZ, JNZ, JMP, J1, J2, J3, J4, RET, temp_interrupt;
wire [3:0]flag_mux_1, flag_mux_2, temp_flag_ex;
wire [7:0]interrupt_mux, curr_add_mux_1, temp_current_address;


//Reg Declaration
reg reg_bank_1 ;
reg [7:0]reg_bank_2;
reg [3:0]reg_bank_3;

//Assigning values to JC, JNC, JZ, JNZ, JMP by anding various combination of bits of ins
assign JC = ~ins[15] && ~ins[16] && ins[17] && ins[18] && ins[19];
assign JNC = ins[15] && ~ins[16] && ins[17] && ins[18] && ins[19];
assign JZ = ~ins[15] && ins[16] && ins[17] && ins[18] && ins[19];
assign JNZ = ins[15] && ins[16] && ins[17] && ins[18] && ins[19];
assign JMP = ~ins[15] && ~ins[16] && ~ins[17] && ins[18] && ins[19];

//Assigning the intermediate and gates the values
assign J1 = JC && flag_mux_2[0];
assign J2 = JNC && ~flag_mux_2[0];
assign J3 = JZ && flag_mux_2[1];
assign J4 = JNZ && ~flag_mux_2[1];

//Assigning the pc_mux_sel the or values of and gates
assign pc_mux_sel = J1 || J2 || J3 || J4 || RET || JMP || reg_bank_1;

//Assigning RET combination of bits of ins
assign RET = ~ins[15] && ~ins[16] && ~ins[17] && ~ins[18] && ins[19];

//Assigning interrupt_mux values according to the select line reg_bank_1 and assigning 8'hF0 if it is 1 or ins[7:0]
assign interrupt_mux = reg_bank_1 == 1'b1 ? 8'hF0 : ins[7:0];

assign temp_interrupt = reset ==1'b1 ? interrupt : 1'b0; 

assign temp_current_address = reset ==1'b1 ? current_address : 1'b0;

assign temp_flag_ex = reset ==1'b1 ? flag_ex : 1'b0;


//Assigning curr_add_mux_1 values according to the select line interrupt and assigning current address if it is 1 or reg_bank_2
assign curr_add_mux_1 = temp_interrupt == 1'b1 ? temp_current_address : reg_bank_2;

//Assigning curr_add_mux_2 values according to the select line RET and assigning reg_bank_2 if it is 1 or interrupt_mux
assign jmp_loc = RET == 1'b0 ? interrupt_mux : reg_bank_2;


//Assigning flag_mux_1 values according to the select line interrupt and assigning flag_ex if it is 1 or reg_bank_3
assign flag_mux_1 = temp_interrupt == 1'b1 ? temp_flag_ex : reg_bank_3;
//Assigning flag_mux_2 values according to the select line RET and assigning flag_ex if it is 0 or reg_bank_3
assign flag_mux_2 = RET == 1'b1 ? reg_bank_3 : temp_flag_ex;



//Assigning values at posedge of clock
always@(posedge clk)
begin

reg_bank_1 <= temp_interrupt;             //Assigning reg_bank_1 the value of temp_interrupt
reg_bank_2 <= curr_add_mux_1;             //Assigning reg_bank_2 the value of curr_add_mux_1
reg_bank_3 <= flag_mux_1;                 //Assigning reg_bank_3 the value of flag_mux_1

end


endmodule
