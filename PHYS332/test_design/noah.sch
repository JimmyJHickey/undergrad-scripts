<?xml version="1.0" encoding="UTF-8"?>
<drawing version="7">
    <attr value="spartan3e" name="DeviceFamilyName">
        <trait delete="all:0" />
        <trait editname="all:0" />
        <trait edittrait="all:0" />
    </attr>
    <netlist>
        <signal name="XLXN_6" />
        <signal name="XLXN_7" />
        <signal name="XLXN_8" />
        <signal name="XLXN_9" />
        <signal name="IN_1" />
        <signal name="IN_2" />
        <signal name="IN_3" />
        <signal name="IN_4" />
        <signal name="OUT_1" />
        <signal name="IN_5" />
        <port polarity="Input" name="IN_1" />
        <port polarity="Input" name="IN_2" />
        <port polarity="Input" name="IN_3" />
        <port polarity="Input" name="IN_4" />
        <port polarity="Output" name="OUT_1" />
        <port polarity="Input" name="IN_5" />
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
        <blockdef name="xor2">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-64" y2="-64" x1="0" />
            <line x2="60" y1="-128" y2="-128" x1="0" />
            <line x2="208" y1="-96" y2="-96" x1="256" />
            <arc ex="44" ey="-144" sx="48" sy="-48" r="56" cx="16" cy="-96" />
            <arc ex="64" ey="-144" sx="64" sy="-48" r="56" cx="32" cy="-96" />
            <line x2="64" y1="-144" y2="-144" x1="128" />
            <line x2="64" y1="-48" y2="-48" x1="128" />
            <arc ex="128" ey="-144" sx="208" sy="-96" r="88" cx="132" cy="-56" />
            <arc ex="208" ey="-96" sx="128" sy="-48" r="88" cx="132" cy="-136" />
        </blockdef>
        <blockdef name="or2">
            <timestamp>2000-1-1T10:10:10</timestamp>
            <line x2="64" y1="-64" y2="-64" x1="0" />
            <line x2="64" y1="-128" y2="-128" x1="0" />
            <line x2="192" y1="-96" y2="-96" x1="256" />
            <arc ex="192" ey="-96" sx="112" sy="-48" r="88" cx="116" cy="-136" />
            <arc ex="48" ey="-144" sx="48" sy="-48" r="56" cx="16" cy="-96" />
            <line x2="48" y1="-144" y2="-144" x1="112" />
            <arc ex="112" ey="-144" sx="192" sy="-96" r="88" cx="116" cy="-56" />
            <line x2="48" y1="-48" y2="-48" x1="112" />
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
        <block symbolname="and2" name="XLXI_2">
            <blockpin signalname="IN_2" name="I0" />
            <blockpin signalname="IN_1" name="I1" />
            <blockpin signalname="XLXN_6" name="O" />
        </block>
        <block symbolname="xor2" name="XLXI_3">
            <blockpin signalname="IN_4" name="I0" />
            <blockpin signalname="IN_3" name="I1" />
            <blockpin signalname="XLXN_7" name="O" />
        </block>
        <block symbolname="or2" name="XLXI_4">
            <blockpin signalname="XLXN_7" name="I0" />
            <blockpin signalname="XLXN_6" name="I1" />
            <blockpin signalname="XLXN_8" name="O" />
        </block>
        <block symbolname="inv" name="XLXI_5">
            <blockpin signalname="XLXN_8" name="I" />
            <blockpin signalname="XLXN_9" name="O" />
        </block>
        <block symbolname="and2" name="XLXI_6">
            <blockpin signalname="IN_5" name="I0" />
            <blockpin signalname="XLXN_9" name="I1" />
            <blockpin signalname="OUT_1" name="O" />
        </block>
    </netlist>
    <sheet sheetnum="1" width="3520" height="2720">
        <instance x="960" y="736" name="XLXI_2" orien="R0" />
        <instance x="992" y="1040" name="XLXI_3" orien="R0" />
        <instance x="1456" y="880" name="XLXI_4" orien="R0" />
        <instance x="1840" y="816" name="XLXI_5" orien="R0" />
        <branch name="XLXN_6">
            <wire x2="1328" y1="640" y2="640" x1="1216" />
            <wire x2="1328" y1="640" y2="752" x1="1328" />
            <wire x2="1456" y1="752" y2="752" x1="1328" />
        </branch>
        <branch name="XLXN_7">
            <wire x2="1344" y1="944" y2="944" x1="1248" />
            <wire x2="1344" y1="816" y2="944" x1="1344" />
            <wire x2="1456" y1="816" y2="816" x1="1344" />
        </branch>
        <branch name="XLXN_8">
            <wire x2="1840" y1="784" y2="784" x1="1712" />
        </branch>
        <branch name="XLXN_9">
            <wire x2="2240" y1="784" y2="784" x1="2064" />
        </branch>
        <instance x="2240" y="912" name="XLXI_6" orien="R0" />
        <branch name="IN_1">
            <wire x2="960" y1="608" y2="608" x1="928" />
        </branch>
        <iomarker fontsize="28" x="928" y="608" name="IN_1" orien="R180" />
        <branch name="IN_2">
            <wire x2="960" y1="672" y2="672" x1="928" />
        </branch>
        <iomarker fontsize="28" x="928" y="672" name="IN_2" orien="R180" />
        <branch name="IN_3">
            <wire x2="992" y1="912" y2="912" x1="960" />
        </branch>
        <iomarker fontsize="28" x="960" y="912" name="IN_3" orien="R180" />
        <branch name="IN_4">
            <wire x2="992" y1="976" y2="976" x1="960" />
        </branch>
        <iomarker fontsize="28" x="960" y="976" name="IN_4" orien="R180" />
        <branch name="OUT_1">
            <wire x2="2528" y1="816" y2="816" x1="2496" />
        </branch>
        <iomarker fontsize="28" x="2528" y="816" name="OUT_1" orien="R0" />
        <branch name="IN_5">
            <wire x2="2240" y1="848" y2="848" x1="2208" />
        </branch>
        <iomarker fontsize="28" x="2208" y="848" name="IN_5" orien="R180" />
    </sheet>
</drawing>