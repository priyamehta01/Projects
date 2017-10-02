`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    16:13:23 10/23/2016 
// Design Name: 
// Module Name:    IP_IM 
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
Date : 19.8.2016
Code Details : Designing the program counter and instruction memory block.
*/

//Module Declaration
module IP_IM(ins, ins_pm, current_address, jmp_loc, pc_mux_sel, stall, stall_pm, reset, clk);

//Output Declaration
output [19:0] ins, ins_pm;										
output [7:0] current_address;

//Input Declaration
input [7:0] jmp_loc;													
input pc_mux_sel, stall, stall_pm, reset, clk;

//Wire Declaration	
wire [7:0] current_address_temp, next_address_temp, current_address_temp1;
wire [19:0] temp_ins_pm;	
wire enable;	
reg [7:0] next_address, address_hold;
reg [19:0] temp_ins;

assign enable = 1;

ROM_IP pv (
  .clka(clk), // input clka
  .ena(enable), // input ena
  .addra(current_address), // input [7 : 0] addra
  .douta(temp_ins_pm) // output [19 : 0] douta
);


/*
//Instance of IP_Core
IP_Core pv (
  .clka(clk), // input clka
  .ena(enable), // input ena
  .addra(current_address), // input [7 : 0] addra
  .douta(temp_ins_pm) // output [19 : 0] douta
);
*/


/*IP_Core ip_core (														
  .clka(clk), // input clk
  .ena(enable), // input en
  .addra(current_address), // input [7 : 0] current_address
  .douta(temp_ins_pm) // output [19 : 0] ins_pm
);
*/

//Assigning values through muxes


assign ins_pm = reset == 1'b1 ?  ins : 20'b00000000000000000000  ;


//Using stall as the select line current_address_temp is assigned value address_hold(1) or next_address(0) coming from register
assign current_address_temp = stall == 1'b1 ?  address_hold : next_address  ;	

//Using pc_mux_sel current_address is assigned value jmp_loc(1) coming from jump block or current_address_temp(0) from previous mux 
assign current_address_temp1 = pc_mux_sel == 1'b1 ?  jmp_loc : current_address_temp  ;

assign current_address = reset == 1'b1 ? current_address_temp1 : 8'b00000000  ;

//Using stall_pm current_address is assigned value 20'b0(1) or ins_pm(0) from program memory/IP Core Generator
assign ins = stall_pm == 1'b0 ?  temp_ins_pm : temp_ins  ;

//Incrementing the address value of previous address and storing it in next_address_temp
assign next_address_temp = current_address + 8'b00000001;	


//Register block
always@(posedge clk)	

//Assigning values at posedge of clock													
begin
if(reset == 1'b1)															
begin
next_address <= next_address_temp;							//next_address_temp from incrementor
address_hold <= current_address;								//current_address from mux
end

//Resetting values
else
begin
next_address <= 0;														
address_hold <= 0;
end

temp_ins <= ins;

end

endmodule


