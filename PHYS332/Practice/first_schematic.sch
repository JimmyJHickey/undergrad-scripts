<?xml version="1.0" encoding="UTF-8"?>
<drawing version="7">
    <attr value="artix7" name="DeviceFamilyName">
        <trait delete="all:0" />
        <trait editname="all:0" />
        <trait edittrait="all:0" />
    </attr>
    <netlist>
        <signal name="XLXN_1" />
        <signal name="XLXN_2" />
        <signal name="XLXN_3" />
        <signal name="XLXN_4" />
        <signal name="XLXN_5" />
        <signal name="XLXN_6" />
        <port polarity="Input" name="XLXN_3" />
        <port polarity="Input" name="XLXN_4" />
        <port polarity="Input" name="XLXN_5" />
        <port polarity="Output" name="XLXN_6" />
        <blockdef name="and2">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-64" y2="-64" x1="0" />
            <line x2="64" y1="-128" y2="-128" x1="0" />
            <line x2="192" y1="-96" y2="-96" x1="256" />
            <arc ex="144" ey="-144" sx="144" sy="-48" r="48" cx="144" cy="-96" />
            <line x2="64" y1="-48" y2="-48" x1="144" />
            <line x2="144" y1="-144" y2="-144" x1="64" />
            <line x2="64" y1="-48" y2="-144" x1="64" />
        </blockdef>
        <blockdef name="inv">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-32" y2="-32" x1="0" />
            <line x2="160" y1="-32" y2="-32" x1="224" />
            <line x2="128" y1="-64" y2="-32" x1="64" />
            <line x2="64" y1="-32" y2="0" x1="128" />
            <line x2="64" y1="0" y2="-64" x1="64" />
            <circle r="16" cx="144" cy="-32" />
        </blockdef>
        <blockdef name="or2l">
            <timestamp>2008-10-7T18:58:26</timestamp>
            <line x2="192" y1="-96" y2="-96" x1="256" />
            <line x2="48" y1="-48" y2="-48" x1="112" />
            <arc ex="112" ey="-144" sx="192" sy="-96" r="88" cx="116" cy="-56" />
            <line x2="48" y1="-144" y2="-144" x1="112" />
            <arc ex="48" ey="-144" sx="48" sy="-48" r="56" cx="16" cy="-96" />
            <arc ex="192" ey="-96" sx="112" sy="-48" r="88" cx="116" cy="-136" />
            <line x2="64" y1="-64" y2="-64" x1="0" />
            <line x2="72" y1="-112" y2="-112" x1="0" />
        </blockdef>
        <block symbolname="inv" name="XLXI_3">
            <blockpin signalname="XLXN_3" name="I" />
            <blockpin signalname="XLXN_1" name="O" />
        </block>
        <block symbolname="or2l" name="XLXI_4">
            <blockpin signalname="XLXN_2" name="O" />
            <blockpin signalname="XLXN_5" name="SRI" />
            <blockpin signalname="XLXN_4" name="DI" />
        </block>
        <block symbolname="and2" name="XLXI_2">
            <blockpin signalname="XLXN_2" name="I0" />
            <blockpin signalname="XLXN_1" name="I1" />
            <blockpin signalname="XLXN_6" name="O" />
        </block>
    </netlist>
    <sheet sheetnum="1" width="3520" height="2720">
        <instance x="512" y="656" name="XLXI_3" orien="R0" />
        <branch name="XLXN_3">
            <wire x2="512" y1="624" y2="624" x1="480" />
        </branch>
        <iomarker fontsize="28" x="480" y="624" name="XLXN_3" orien="R180" />
        <instance x="448" y="944" name="XLXI_4" orien="R0" />
        <branch name="XLXN_4">
            <wire x2="448" y1="832" y2="832" x1="416" />
        </branch>
        <branch name="XLXN_5">
            <wire x2="448" y1="880" y2="880" x1="416" />
        </branch>
        <iomarker fontsize="28" x="416" y="832" name="XLXN_4" orien="R180" />
        <iomarker fontsize="28" x="416" y="880" name="XLXN_5" orien="R180" />
        <branch name="XLXN_6">
            <wire x2="1344" y1="736" y2="736" x1="1328" />
            <wire x2="1360" y1="736" y2="736" x1="1344" />
        </branch>
        <instance x="1072" y="832" name="XLXI_2" orien="R0" />
        <iomarker fontsize="28" x="1360" y="736" name="XLXN_6" orien="R0" />
        <branch name="XLXN_2">
            <wire x2="720" y1="848" y2="848" x1="704" />
            <wire x2="1072" y1="768" y2="768" x1="720" />
            <wire x2="720" y1="768" y2="848" x1="720" />
        </branch>
        <branch name="XLXN_1">
            <wire x2="752" y1="624" y2="624" x1="736" />
            <wire x2="752" y1="624" y2="704" x1="752" />
            <wire x2="1072" y1="704" y2="704" x1="752" />
        </branch>
    </sheet>
</drawing>