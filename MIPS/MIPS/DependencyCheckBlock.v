`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:10:33 10/23/2016 
// Design Name: 
// Module Name:    DependencyCheckBlock 
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
module DependencyCheckBlock(mux_sel_a, mux_sel_b, imm_sel, imm, mem_en_dec, mem_rw_dec, mem_mux_sel_dec, RW_dec, Op_dec, ins, clk, reset);

output imm_sel, mem_en_dec, mem_rw_dec, mem_mux_sel_dec;
output [1:0] mux_sel_a,mux_sel_b;
output [7:0] imm;
output [4:0] RW_dec, Op_dec;

input [19:0]ins;
input clk, reset;

wire Imm, LD_ST, and1, and2, and3, and5, and6, and7, and8, and9, and10, and11, nor1, comp1, comp2, comp3, comp4, comp5, comp6;
wire [14:0] and4, ext;
reg [7:0] reg2;
wire [7:0]reg2_temp;
wire [4:0] reg1_temp, reg3_temp, reg4_temp, reg5_temp, reg6_temp, reg7_temp, reg8_temp;
reg [4:0] reg1, reg3, reg4, reg5, reg6, reg7, reg8;
reg Q1, Q_1, Q2, Q_2, Q3, Q_3, Q4, Q_4;
wire temp_Q1, temp_Q2, temp_Q3, temp_Q4, temp_Q_1, temp_Q_2, temp_Q_3, temp_Q_4;

assign Imm = ~ins[19] & ins[18];
assign LD_ST = ins[19] & ~ins[18] & ins[17] & ~ins[16];

assign and1 = ins[19] & ins[18] & ~ins[17] & ~ins[16] & ~ins[15];
assign and2 = ins[19] & ins[18] & ins[17];
assign and3 = ins[19] & ~ins[18] & ins[17] & ~ins[16] & ~ins[15] & ~Q1; 
assign and4 = ins[14:0] & ext;

assign temp_Q1=reset ==1'b1 ?and3 : 1'b0;

assign temp_Q2 = reset == 1'b1 ?and5 : 1'b0;

assign temp_Q3 = reset == 1'b1 ?and6 : 1'b0;

assign temp_Q4 = reset == 1'b1 ?Imm : 1'b0;

assign reg2_temp = reset == 1'b1 ?{1'b0, 1'b0, 1'b0, ins[4:0]} : 8'b00000000;

assign reg1_temp = reset == 1'b1 ?ins[19:15] : 5'b00000;

assign reg3_temp = reset == 1'b1 ?and4[9:5] : 5'b00000;

assign reg4_temp = reset == 1'b1 ?and4[14:10] : 5'b00000;

assign reg5_temp = reset == 1'b1 ?and4[4:0] : 5'b00000;

assign reg6_temp = reset == 1'b1 ?reg4 : 5'b00000;

assign reg7_temp = reset == 1'b1 ?reg6 : 5'b00000;

assign reg8_temp = reset == 1'b1 ?reg7 : 5'b00000;

always @ (posedge clk)
begin 

Q1   <= temp_Q1;

Q2   <= temp_Q2;

Q3   <= temp_Q3;

Q4   <= temp_Q4;

reg2 <= reg2_temp;

reg1 <= reg1_temp;

reg3 <= reg3_temp;

reg4 <= reg4_temp;

reg5 <= reg5_temp;

reg6 <= reg6_temp;

reg7 <= reg7_temp;

reg8 <= reg8_temp;



end


assign imm = reg2;


assign Op_dec = reg1;

assign nor1 = ~(and1 || and2 || Q1);

assign ext = {nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1,nor1, nor1};


assign and5 = ins[15] & ~Q2;

assign and6 = LD_ST & ~Q3;

assign imm_sel =  Q4;

assign mem_rw_dec =  Q2;

assign mem_mux_sel_dec = ~Q2 & Q3;

assign mem_en_dec = Q3;

assign comp1 = reg6==reg3 ?1'b1 : 1'b0;

assign comp2 = reg7==reg3 ?1'b1 : 1'b0;

assign comp3 = reg8==reg3 ?1'b1 : 1'b0;

assign comp4 = reg6==reg5 ?1'b1 : 1'b0;

assign comp5 = reg7==reg5 ?1'b1 : 1'b0;

assign comp6 = reg5==reg8 ?1'b1 : 1'b0;

assign and8 = ~comp1 & comp2;

assign and9 = ~comp1 & ~comp2 && comp3;

assign and10 = ~comp4 & comp5;

assign and11 = ~comp4 & ~comp5 & comp6;

assign mux_sel_a = comp1 == 1'b1 ? 2'b01 : 
						(and8 == 1'b1 ? 2'b10 : 
						(and9 == 1'b1 ? 2'b11 : 2'b00 ));

assign mux_sel_b = comp4 == 1'b1 ? 2'b01 : 
						(and10 == 1'b1 ? 2'b10 : 
						(and11 == 1'b1 ? 2'b11 : 2'b00));
						
assign RW_dec = reg4;
						
endmodule

