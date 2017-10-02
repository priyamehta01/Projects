/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

#include "xsi.h"

struct XSI_INFO xsi_info;



int main(int argc, char **argv)
{
    xsi_init_design(argc, argv);
    xsi_register_info(&xsi_info);

    xsi_register_min_prec_unit(-12);
    work_m_00000000003822590030_1878678253_init();
    work_m_00000000002090474108_3313263128_init();
    xilinxcorelib_ver_m_00000000001358910285_2123670738_init();
    xilinxcorelib_ver_m_00000000001358910285_1298878945_init();
    xilinxcorelib_ver_m_00000000001687936702_0873297193_init();
    xilinxcorelib_ver_m_00000000000277421008_3292387384_init();
    xilinxcorelib_ver_m_00000000001603977570_2722888622_init();
    work_m_00000000003388451136_0353211399_init();
    work_m_00000000000719635791_0406329862_init();
    work_m_00000000000313304359_2316644670_init();
    work_m_00000000004097777244_1520693549_init();
    work_m_00000000001055736857_1540373756_init();
    xilinxcorelib_ver_m_00000000001358910285_2475621038_init();
    xilinxcorelib_ver_m_00000000001358910285_1868967107_init();
    xilinxcorelib_ver_m_00000000001687936702_3055161089_init();
    xilinxcorelib_ver_m_00000000000277421008_2170411216_init();
    xilinxcorelib_ver_m_00000000001603977570_2527286559_init();
    work_m_00000000003869038185_1134408895_init();
    work_m_00000000000740511743_3258266500_init();
    work_m_00000000000925592442_1729233856_init();
    work_m_00000000002335825965_3515808994_init();
    work_m_00000000000327903391_2793982751_init();
    work_m_00000000004134447467_2073120511_init();


    xsi_register_tops("work_m_00000000000327903391_2793982751");
    xsi_register_tops("work_m_00000000004134447467_2073120511");


    return xsi_run_simulation(argc, argv);

}
