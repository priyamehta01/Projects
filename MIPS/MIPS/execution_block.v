`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:38:35 10/23/2016 
// Design Name: 
// Module Name:    execution_block 
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
module execution_block(flag_ex, ans_ex, data_out, B_Bypass, mem_en_ex, mem_rw_ex, mem_mux_sel_ex, RW_ex, A, B, data_in, op_dec, clk, mem_en_dec, mem_rw_dec, mem_mux_sel_dec, RW_dec, reset);			//Module 

output reg [7:0]ans_ex, data_out, B_Bypass;
output reg [4:0]RW_ex;
output [3:0]flag_ex;
output reg mem_en_ex, mem_rw_ex, mem_mux_sel_ex;

wire [7:0]a1, a2, a3, a4, a5, a6, a7, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28;
wire [6:0]ct, ct1;
wire [7:0]ans_ex1;
wire [7:0]a8;
wire C, C1, O, O1, Z;
wire [7:0]ans_temp, data_out_buff;
wire [7:0]B1;
wire [3:0]flag_temp;
wire [7:0]ans_ex_temp, data_out_temp, B_Bypass_temp, data_out_temp1;
wire [4:0]RW_ex_temp;
wire mem_en_ex_temp, mem_rw_ex_temp, mem_mux_sel_ex_temp;
reg [3:0]flag_ex_temp;
reg [3:0]flag_ex_1;

input [7:0]A, B, data_in;
input [4:0]op_dec, RW_dec;
input clk, mem_en_dec, mem_rw_dec, mem_mux_sel_dec, reset;


assign a3 = B;
assign a4 = A&B;
assign a5 = A|B;
assign a6 = A^B;
assign a7 = ~B;
assign a8 = ans_ex;
assign a9 = A;
assign a10 = data_in;
assign a11 = A<<B[2:0];
assign a12 = A>>B[2:0];

assign a13 = B[2:0] == 3'b000 ?  A :
            ( B[2:0] == 3'b001 ? { A[7], A[7:1] } : 
				( B[2:0] == 3'b010 ? { A[7], A[7], A[7:2] } : 
				( B[2:0] == 3'b011 ? { A[7], A[7], A[7], A[7:3] } : 
				( B[2:0] == 3'b100 ? { A[7], A[7], A[7], A[7], A[7:4] } : 
				( B[2:0] == 3'b101 ? { A[7], A[7], A[7], A[7], A[7], A[7:5] } : 
				( B[2:0] == 3'b110 ? { A[7], A[7], A[7], A[7], A[7], A[7], A[7:6] } : 
				( B[2:0] == 3'b111 ? { A[7], A[7], A[7], A[7], A[7], A[7], A[7], A[7] } : 
				(8'b00000000 )))))))) ;

assign data_out_buff = (op_dec == 5'b10111) ? A : 8'b0;


assign {ct[0],a1[0]}=A[0]+B[0];
assign {ct[1],a1[1]}=A[1]+B[1]+ct[0];
assign {ct[2],a1[2]}=A[2]+B[2]+ct[1];
assign {ct[3],a1[3]}=A[3]+B[3]+ct[2];
assign {ct[4],a1[4]}=A[4]+B[4]+ct[3];
assign {ct[5],a1[5]}=A[5]+B[5]+ct[4];
assign {ct[6],a1[6]}=A[6]+B[6]+ct[5];
assign {C ,a1[7]}=A[7]+B[7]+ct[6];
assign O = ct[6]^C;

assign B1 = ~B + 8'b00000001;

assign {ct1[0],a2[0]}=A[0]+(B1[0]);
assign {ct1[1],a2[1]}=A[1]+(B1[1])+ct1[0];
assign {ct1[2],a2[2]}=A[2]+(B1[2])+ct1[1];
assign {ct1[3],a2[3]}=A[3]+(B1[3])+ct1[2];
assign {ct1[4],a2[4]}=A[4]+(B1[4])+ct1[3];
assign {ct1[5],a2[5]}=A[5]+(B1[5])+ct1[4];
assign {ct1[6],a2[6]}=A[6]+(B1[6])+ct1[5];
assign {C1 ,a2[7]}=A[7]+(B1[7])+ct1[6];
assign O1 = ct1[6]^C1;

assign ans_temp =  op_dec == 5'b00000 ? a1 : (op_dec == 5'b00001 ? a2 :(op_dec == 5'b00010 ? a3 :
						(op_dec == 5'b00100 ? a4 : (op_dec == 5'b00101 ? a5 :(op_dec == 5'b00110 ? a6 :
						(op_dec == 5'b00111 ? a7 : (op_dec == 5'b01000 ? a1 :(op_dec == 5'b01001 ? a2 :
						(op_dec == 5'b01010 ? a3 : (op_dec == 5'b01100 ? a4 :(op_dec == 5'b01101 ? a5 :
						(op_dec == 5'b01110 ? a6 : (op_dec == 5'b01111 ? a7 :(op_dec == 5'b10000 ? a8 :
						(op_dec == 5'b10001 ? a8 : (op_dec == 5'b10100 ? a9 :(op_dec == 5'b10101 ? a9 :
						(op_dec == 5'b10110 ? a10: (op_dec == 5'b10111 ? a8 :(op_dec == 5'b11000 ? a8 :
						(op_dec == 5'b11001 ? a11: (op_dec == 5'b11010 ? a12:(op_dec == 5'b11011 ? a13:
						(op_dec == 5'b11100 ? a8 : (op_dec == 5'b11101 ? a8 :(op_dec == 5'b11110 ? a8 :( op_dec == 5'b11111 ? a8
						:8'b00000000)))))))))))))))))))))))))));
						

assign Z = ans_temp[0]| ans_temp[1]| ans_temp[2]| ans_temp[3]| ans_temp[4]| ans_temp[5] | ans_temp[6]| ans_temp[7];

assign flag_temp[0] = op_dec == 5'b00000 ? C : (op_dec == 5'b00001 ? C1 :(op_dec == 5'b00010 ? 1'b0 :
						 (op_dec == 5'b00100 ? 1'b0 : (op_dec == 5'b00101 ? 1'b0 :(op_dec == 5'b00110 ? 1'b0 :
						 (op_dec == 5'b00111 ? 1'b0 : (op_dec == 5'b01000 ? C :(op_dec == 5'b01001 ? C1 :
						 (op_dec == 5'b01010 ? 1'b0 : (op_dec == 5'b01100 ? 1'b0 :(op_dec == 5'b01101 ? 1'b0 :
						 (op_dec == 5'b01110 ? 1'b0 : (op_dec == 5'b01111 ? 1'b0 :(op_dec == 5'b10000 ? 1'b0 :
						 (op_dec == 5'b10001 ? 1'b0 : (op_dec == 5'b10100 ? flag_ex_temp[0] :(op_dec == 5'b10101 ? flag_ex_temp[0] :
						 (op_dec == 5'b10110 ? 1'b0 : (op_dec == 5'b10111 ? flag_ex_temp[0] :(op_dec == 5'b11000 ? flag_ex_temp[0] :
						 (op_dec == 5'b11001 ? 1'b0 : (op_dec == 5'b11010 ? 1'b0 :(op_dec == 5'b11011 ? 1'b0 :
						 (op_dec == 5'b11100 ? flag_ex_temp[0] : (op_dec == 5'b11101 ? flag_ex_temp[0] :(op_dec == 5'b11110 ? flag_ex_temp[0] :
						 ( op_dec == 5'b11111 ? flag_ex_temp[0] :1'b0
						  )))))))))))))))))))))))))));


assign flag_temp[1] = ~Z;

assign flag_temp[2] = op_dec == 5'b00000 ? O    : (op_dec == 5'b00001 ? O1  : (op_dec == 5'b00010 ? 1'b0 :
                   (op_dec == 5'b00100 ? 1'b0 : (op_dec == 5'b00101 ? 1'b0: (op_dec == 5'b00110 ? 1'b0 :
						 (op_dec == 5'b00111 ? 1'b0 : (op_dec == 5'b01000 ? O   : (op_dec == 5'b01001 ? O1   :
						 (op_dec == 5'b01010 ? 1'b0 : (op_dec == 5'b01100 ? 1'b0: (op_dec == 5'b01101 ? 1'b0 : 
						 (op_dec == 5'b01110 ? 1'b0 : (op_dec == 5'b01111 ? 1'b0: (op_dec == 5'b10000 ? 1'b0 :
						 (op_dec == 5'b10001 ? 1'b0 : (op_dec == 5'b10100 ? flag_ex_temp[2] : 
						 (op_dec == 5'b10101 ? flag_ex_temp[2] : (op_dec == 5'b10110 ? 1'b0 : (op_dec == 5'b10111 ? flag_ex_temp[2]:
						 (op_dec == 5'b11000 ? flag_ex_temp[2] : (op_dec == 5'b11001 ? 1'b0 : (op_dec == 5'b11010 ? 1'b0 : 
						 (op_dec == 5'b11011 ? 1'b0 : (op_dec == 5'b11100 ? flag_ex_temp[2] : (op_dec == 5'b11101 ? flag_ex_temp[2]:
						 (op_dec == 5'b11101 ? flag_ex_temp[2] : (op_dec == 5'b11110 ? flag_ex_temp[2] : (op_dec == 5'b11111 ? flag_ex_temp[2]:
						 1'b0))))))))))))))))))))))))))));
						 
assign flag_temp[3] = ans_temp[0] ^ ans_temp[1] ^ ans_temp[2] ^ ans_temp[3] ^ ans_temp[4] ^ ans_temp[5] ^ ans_temp[6] ^ ans_temp[7]; 

assign ans_ex_temp = reset == 1'b1 ? ans_temp : 8'b0;
assign data_out_temp1 = op_dec == 5'b10111 ? data_out_buff : data_out;
assign data_out_temp = reset == 1'b1 ? data_out_temp1 : 8'b0;
assign B_Bypass_temp = reset == 1'b1 ? B : 8'b0;
assign mem_en_ex_temp = reset == 1'b1 ? mem_en_dec : 1'b0;
assign mem_rw_ex_temp = reset == 1'b1 ? mem_rw_dec : 1'b0;
assign mem_mux_sel_ex_temp = reset == 1'b1 ? mem_mux_sel_dec : 1'b0;
assign RW_ex_temp = reset == 1'b1 ? RW_dec : 5'b0;

/*always @(posedge clk)
begin
	if(reset == 1'b1)
	begin
	ans_ex <= ans_temp;
	if(op_dec == 5'b10111)
	data_out <= data_out_buff;
	else
	data_out <= data_out;
	B_Bypass <= B;
	mem_en_ex <= mem_en_dec;
	mem_rw_ex <= mem_rw_dec;
	mem_mux_sel_ex <= mem_mux_sel_dec;
	RW_ex <= RW_dec;
	end
	
	else
	begin
	ans_ex <= 0;
	data_out <= 0;
	B_Bypass <= 0;
	mem_en_ex <= 0;
	mem_rw_ex <= 0;
	mem_mux_sel_ex <= 0;
	RW_ex <= 0;
	end
end	*/

/*always @(*)
begin
	if(op_dec == 5'b10100 || op_dec == 5'b10101)
	flag_ex <=flag_ex;
	
	else
	flag_ex <=flag_temp;
end*/

always @(posedge clk)
begin

ans_ex <= ans_ex_temp;
data_out <= data_out_temp;
B_Bypass <= B_Bypass_temp;
mem_en_ex <= mem_en_ex_temp;
mem_rw_ex <= mem_rw_ex_temp;
mem_mux_sel_ex <= mem_mux_sel_ex_temp;
RW_ex <= RW_ex_temp;
flag_ex_temp[0] <= flag_temp[0];
flag_ex_temp[2] <= flag_temp[2];
flag_ex_1 <= flag_ex;

end 

assign flag_ex = op_dec == 5'b10100 || op_dec == 5'b10101 ? flag_ex_1 : flag_temp; 

endmodule