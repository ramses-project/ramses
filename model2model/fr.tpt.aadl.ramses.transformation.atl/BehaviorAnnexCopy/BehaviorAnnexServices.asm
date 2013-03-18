<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="BehaviorAnnexServices"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="self"/>
		<constant value="getBehaviorAnnex"/>
		<constant value="MAADLBA!BehaviorElement;"/>
		<constant value="0"/>
		<constant value="BehaviorAnnex"/>
		<constant value="AADLBA"/>
		<constant value="J.oclIsTypeOf(J):J"/>
		<constant value="10"/>
		<constant value="J.eContainer():J"/>
		<constant value="J.getBehaviorAnnex():J"/>
		<constant value="11"/>
		<constant value="25:6-25:10"/>
		<constant value="25:23-25:43"/>
		<constant value="25:6-25:44"/>
		<constant value="28:3-28:7"/>
		<constant value="28:3-28:20"/>
		<constant value="28:3-28:39"/>
		<constant value="26:3-26:7"/>
		<constant value="25:2-29:7"/>
		<constant value="getState"/>
		<constant value="MAADLBA!BehaviorAnnex;"/>
		<constant value="1"/>
		<constant value="J"/>
		<constant value="Sequence"/>
		<constant value="#native"/>
		<constant value="states"/>
		<constant value="2"/>
		<constant value="name"/>
		<constant value="J.=(J):J"/>
		<constant value="B.not():B"/>
		<constant value="15"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="CJ.asSequence():QJ"/>
		<constant value="QJ.first():J"/>
		<constant value="33:2-33:6"/>
		<constant value="33:2-33:13"/>
		<constant value="33:22-33:23"/>
		<constant value="33:22-33:28"/>
		<constant value="33:31-33:35"/>
		<constant value="33:22-33:35"/>
		<constant value="33:2-33:36"/>
		<constant value="e"/>
	</cp>
	<operation name="1">
		<context type="2"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="4">
		<context type="5"/>
		<parameters>
		</parameters>
		<code>
			<load arg="6"/>
			<push arg="7"/>
			<push arg="8"/>
			<findme/>
			<call arg="9"/>
			<if arg="10"/>
			<load arg="6"/>
			<call arg="11"/>
			<call arg="12"/>
			<goto arg="13"/>
			<load arg="6"/>
		</code>
		<linenumbertable>
			<lne id="14" begin="0" end="0"/>
			<lne id="15" begin="1" end="3"/>
			<lne id="16" begin="0" end="4"/>
			<lne id="17" begin="6" end="6"/>
			<lne id="18" begin="6" end="7"/>
			<lne id="19" begin="6" end="8"/>
			<lne id="20" begin="10" end="10"/>
			<lne id="21" begin="0" end="10"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="3" begin="0" end="10"/>
		</localvariabletable>
	</operation>
	<operation name="22">
		<context type="23"/>
		<parameters>
			<parameter name="24" type="25"/>
		</parameters>
		<code>
			<push arg="26"/>
			<push arg="27"/>
			<new/>
			<load arg="6"/>
			<get arg="28"/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<get arg="30"/>
			<load arg="24"/>
			<call arg="31"/>
			<call arg="32"/>
			<if arg="33"/>
			<load arg="29"/>
			<call arg="34"/>
			<enditerate/>
			<call arg="35"/>
			<call arg="36"/>
		</code>
		<linenumbertable>
			<lne id="37" begin="3" end="3"/>
			<lne id="38" begin="3" end="4"/>
			<lne id="39" begin="7" end="7"/>
			<lne id="40" begin="7" end="8"/>
			<lne id="41" begin="9" end="9"/>
			<lne id="42" begin="7" end="10"/>
			<lne id="43" begin="0" end="17"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="44" begin="6" end="14"/>
			<lve slot="0" name="3" begin="0" end="17"/>
			<lve slot="1" name="30" begin="0" end="17"/>
		</localvariabletable>
	</operation>
</asm>
