<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="CopyElementHolders"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="__exec__"/>
		<constant value="copySubprogramAccessHolder"/>
		<constant value="MAADLBA!SubprogramAccessHolder;"/>
		<constant value="MAADLI!ComponentInstance;"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src_SubprogramAccessHolder"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="c"/>
		<constant value="target_SubprogramAccessHolder"/>
		<constant value="SubprogramAccessHolder"/>
		<constant value="AADLBA"/>
		<constant value="3"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="element"/>
		<constant value="35:13-35:39"/>
		<constant value="35:13-35:47"/>
		<constant value="35:4-35:47"/>
		<constant value="33:3-36:4"/>
		<constant value="39:3-39:32"/>
		<constant value="39:3-39:33"/>
		<constant value="37:2-40:3"/>
		<constant value="copyEventPortHolder"/>
		<constant value="MAADLBA!EventPortHolder;"/>
		<constant value="src_EventPortHolder"/>
		<constant value="target_EventPortHolder"/>
		<constant value="EventPortHolder"/>
		<constant value="51:13-51:32"/>
		<constant value="51:13-51:40"/>
		<constant value="51:4-51:40"/>
		<constant value="49:3-52:4"/>
		<constant value="55:3-55:25"/>
		<constant value="55:3-55:26"/>
		<constant value="53:2-56:3"/>
		<constant value="copyEventDataPortHolder"/>
		<constant value="MAADLBA!EventDataPortHolder;"/>
		<constant value="src_EventDataPortHolder"/>
		<constant value="target_EventDataPortHolder"/>
		<constant value="EventDataPortHolder"/>
		<constant value="67:13-67:36"/>
		<constant value="67:13-67:44"/>
		<constant value="67:4-67:44"/>
		<constant value="65:3-68:4"/>
		<constant value="71:3-71:29"/>
		<constant value="71:3-71:30"/>
		<constant value="69:2-72:3"/>
		<constant value="copyDataPortHolder"/>
		<constant value="MAADLBA!DataPortHolder;"/>
		<constant value="src_DataPortHolder"/>
		<constant value="target_DataPortHolder"/>
		<constant value="DataPortHolder"/>
		<constant value="83:13-83:31"/>
		<constant value="83:13-83:39"/>
		<constant value="83:4-83:39"/>
		<constant value="81:3-84:4"/>
		<constant value="87:3-87:24"/>
		<constant value="87:3-87:25"/>
		<constant value="85:2-88:3"/>
		<constant value="copyCalledSubprogramHolder"/>
		<constant value="MAADLBA!CalledSubprogramHolder;"/>
		<constant value="src_CalledSubprogramHolder"/>
		<constant value="target_CalledSubprogramHolder"/>
		<constant value="CalledSubprogramHolder"/>
		<constant value="99:13-99:39"/>
		<constant value="99:13-99:47"/>
		<constant value="99:4-99:47"/>
		<constant value="97:3-100:4"/>
		<constant value="103:3-103:32"/>
		<constant value="103:3-103:33"/>
		<constant value="101:2-104:3"/>
		<constant value="copyDataAccessHolder"/>
		<constant value="MAADLBA!DataAccessHolder;"/>
		<constant value="src_DataAccessHolder"/>
		<constant value="target_DataAccessHolder"/>
		<constant value="DataAccessHolder"/>
		<constant value="115:13-115:33"/>
		<constant value="115:13-115:41"/>
		<constant value="115:4-115:41"/>
		<constant value="113:3-116:4"/>
		<constant value="119:3-119:26"/>
		<constant value="119:3-119:27"/>
		<constant value="117:2-120:3"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="40">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="42"/>
			<parameter name="29" type="43"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="41"/>
			<pcall arg="45"/>
			<dup/>
			<push arg="46"/>
			<load arg="19"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="48"/>
			<load arg="29"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="49"/>
			<push arg="50"/>
			<push arg="51"/>
			<new/>
			<dup/>
			<store arg="52"/>
			<pcall arg="53"/>
			<pushf/>
			<pcall arg="54"/>
			<load arg="52"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="55"/>
			<call arg="30"/>
			<set arg="55"/>
			<pop/>
			<load arg="52"/>
			<load arg="52"/>
		</code>
		<linenumbertable>
			<lne id="56" begin="29" end="29"/>
			<lne id="57" begin="29" end="30"/>
			<lne id="58" begin="27" end="32"/>
			<lne id="59" begin="26" end="33"/>
			<lne id="60" begin="34" end="34"/>
			<lne id="61" begin="34" end="34"/>
			<lne id="62" begin="34" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="49" begin="22" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="46" begin="0" end="35"/>
			<lve slot="2" name="48" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="63">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="64"/>
			<parameter name="29" type="43"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="63"/>
			<pcall arg="45"/>
			<dup/>
			<push arg="65"/>
			<load arg="19"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="48"/>
			<load arg="29"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="66"/>
			<push arg="67"/>
			<push arg="51"/>
			<new/>
			<dup/>
			<store arg="52"/>
			<pcall arg="53"/>
			<pushf/>
			<pcall arg="54"/>
			<load arg="52"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="55"/>
			<call arg="30"/>
			<set arg="55"/>
			<pop/>
			<load arg="52"/>
			<load arg="52"/>
		</code>
		<linenumbertable>
			<lne id="68" begin="29" end="29"/>
			<lne id="69" begin="29" end="30"/>
			<lne id="70" begin="27" end="32"/>
			<lne id="71" begin="26" end="33"/>
			<lne id="72" begin="34" end="34"/>
			<lne id="73" begin="34" end="34"/>
			<lne id="74" begin="34" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="66" begin="22" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="65" begin="0" end="35"/>
			<lve slot="2" name="48" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="75">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="76"/>
			<parameter name="29" type="43"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="75"/>
			<pcall arg="45"/>
			<dup/>
			<push arg="77"/>
			<load arg="19"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="48"/>
			<load arg="29"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="78"/>
			<push arg="79"/>
			<push arg="51"/>
			<new/>
			<dup/>
			<store arg="52"/>
			<pcall arg="53"/>
			<pushf/>
			<pcall arg="54"/>
			<load arg="52"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="55"/>
			<call arg="30"/>
			<set arg="55"/>
			<pop/>
			<load arg="52"/>
			<load arg="52"/>
		</code>
		<linenumbertable>
			<lne id="80" begin="29" end="29"/>
			<lne id="81" begin="29" end="30"/>
			<lne id="82" begin="27" end="32"/>
			<lne id="83" begin="26" end="33"/>
			<lne id="84" begin="34" end="34"/>
			<lne id="85" begin="34" end="34"/>
			<lne id="86" begin="34" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="78" begin="22" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="77" begin="0" end="35"/>
			<lve slot="2" name="48" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="87">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="88"/>
			<parameter name="29" type="43"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="87"/>
			<pcall arg="45"/>
			<dup/>
			<push arg="89"/>
			<load arg="19"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="48"/>
			<load arg="29"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="90"/>
			<push arg="91"/>
			<push arg="51"/>
			<new/>
			<dup/>
			<store arg="52"/>
			<pcall arg="53"/>
			<pushf/>
			<pcall arg="54"/>
			<load arg="52"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="55"/>
			<call arg="30"/>
			<set arg="55"/>
			<pop/>
			<load arg="52"/>
			<load arg="52"/>
		</code>
		<linenumbertable>
			<lne id="92" begin="29" end="29"/>
			<lne id="93" begin="29" end="30"/>
			<lne id="94" begin="27" end="32"/>
			<lne id="95" begin="26" end="33"/>
			<lne id="96" begin="34" end="34"/>
			<lne id="97" begin="34" end="34"/>
			<lne id="98" begin="34" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="90" begin="22" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="89" begin="0" end="35"/>
			<lve slot="2" name="48" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="99">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="100"/>
			<parameter name="29" type="43"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="99"/>
			<pcall arg="45"/>
			<dup/>
			<push arg="101"/>
			<load arg="19"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="48"/>
			<load arg="29"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="102"/>
			<push arg="103"/>
			<push arg="51"/>
			<new/>
			<dup/>
			<store arg="52"/>
			<pcall arg="53"/>
			<pushf/>
			<pcall arg="54"/>
			<load arg="52"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="55"/>
			<call arg="30"/>
			<set arg="55"/>
			<pop/>
			<load arg="52"/>
			<load arg="52"/>
		</code>
		<linenumbertable>
			<lne id="104" begin="29" end="29"/>
			<lne id="105" begin="29" end="30"/>
			<lne id="106" begin="27" end="32"/>
			<lne id="107" begin="26" end="33"/>
			<lne id="108" begin="34" end="34"/>
			<lne id="109" begin="34" end="34"/>
			<lne id="110" begin="34" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="102" begin="22" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="101" begin="0" end="35"/>
			<lve slot="2" name="48" begin="0" end="35"/>
		</localvariabletable>
	</operation>
	<operation name="111">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="112"/>
			<parameter name="29" type="43"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="111"/>
			<pcall arg="45"/>
			<dup/>
			<push arg="113"/>
			<load arg="19"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="48"/>
			<load arg="29"/>
			<pcall arg="47"/>
			<dup/>
			<push arg="114"/>
			<push arg="115"/>
			<push arg="51"/>
			<new/>
			<dup/>
			<store arg="52"/>
			<pcall arg="53"/>
			<pushf/>
			<pcall arg="54"/>
			<load arg="52"/>
			<dup/>
			<getasm/>
			<load arg="19"/>
			<get arg="55"/>
			<call arg="30"/>
			<set arg="55"/>
			<pop/>
			<load arg="52"/>
			<load arg="52"/>
		</code>
		<linenumbertable>
			<lne id="116" begin="29" end="29"/>
			<lne id="117" begin="29" end="30"/>
			<lne id="118" begin="27" end="32"/>
			<lne id="119" begin="26" end="33"/>
			<lne id="120" begin="34" end="34"/>
			<lne id="121" begin="34" end="34"/>
			<lne id="122" begin="34" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="114" begin="22" end="35"/>
			<lve slot="0" name="17" begin="0" end="35"/>
			<lve slot="1" name="113" begin="0" end="35"/>
			<lve slot="2" name="48" begin="0" end="35"/>
		</localvariabletable>
	</operation>
</asm>
