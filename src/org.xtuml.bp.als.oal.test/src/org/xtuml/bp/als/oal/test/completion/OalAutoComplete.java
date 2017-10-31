//=====================================================================
//
// NOTE: This file was generated, but is maintained by hand.
// Generated by: UnitTestGenerator.pl
// Version:      1.15
// Matrix:       oal_autocomplete_matrix.txt
//
//=====================================================================

package org.xtuml.bp.als.oal.test.completion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.IEditorPart;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.xtuml.bp.core.Action_c;
import org.xtuml.bp.core.Body_c;
import org.xtuml.bp.core.BridgeBody_c;
import org.xtuml.bp.core.Bridge_c;
import org.xtuml.bp.core.Component_c;
import org.xtuml.bp.core.DerivedAttributeBody_c;
import org.xtuml.bp.core.DerivedBaseAttribute_c;
import org.xtuml.bp.core.FunctionBody_c;
import org.xtuml.bp.core.Function_c;
import org.xtuml.bp.core.Ooaofooa;
import org.xtuml.bp.core.OperationBody_c;
import org.xtuml.bp.core.Operation_c;
import org.xtuml.bp.core.Package_c;
import org.xtuml.bp.core.ProvidedOperationBody_c;
import org.xtuml.bp.core.ProvidedOperation_c;
import org.xtuml.bp.core.ProvidedSignalBody_c;
import org.xtuml.bp.core.ProvidedSignal_c;
import org.xtuml.bp.core.RequiredOperationBody_c;
import org.xtuml.bp.core.RequiredOperation_c;
import org.xtuml.bp.core.RequiredSignalBody_c;
import org.xtuml.bp.core.RequiredSignal_c;
import org.xtuml.bp.core.StateActionBody_c;
import org.xtuml.bp.core.TransitionActionBody_c;
import org.xtuml.bp.core.common.ClassQueryInterface_c;
import org.xtuml.bp.core.common.NonRootModelElement;
import org.xtuml.bp.core.ui.Selection;
import org.xtuml.bp.core.util.ActionLanguageDescriptionUtil;
import org.xtuml.bp.test.common.OrderedRunner;
import org.xtuml.bp.ui.canvas.test.CanvasTest;
import org.xtuml.bp.ui.text.activity.ParseAllActivitiesAction;

@RunWith(OrderedRunner.class)
public class OalAutoComplete extends CanvasTest {
    public static boolean generateResults = false;
    public static boolean useDrawResults = false;
    public static boolean implementationExists = true;
    String[] results = null;

    String test_id = "";

    protected String getResultName() {
        return getClass().getSimpleName() + "_" + test_id;
    }

    protected IEditorPart fActiveEditor;

    protected IEditorPart getActiveEditor() {
        return fActiveEditor;
    }

    public OalAutoComplete(String subTypeClassName, String subTypeArg0) {
        super(null, subTypeArg0);
    }

    protected String getTestId(String src, String dest, String count) {
        return "test_" + count;
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        Ooaofooa.disableChangeNotification();
        assertTrue( "Completion assistance is not implemented for OAL", implementationExists );
    }

    private static Method setUpMethod;
    private static Method computeMethod;
    private static Method cleanUpMethod;
    private static Method getReplacementTextMethod;
    private static Object processor;
    
    private static Method lineAndColumnToPosition;
    private static Method positionToLine;
    
    @Override
    protected void initialSetup() throws Exception {
        loadProject("oal_autocomplete");
        modelRoot = Ooaofooa.getInstance("/oal_autocomplete/models/oal_autocomplete/Container/Container.xtuml");
        // create the initial OAL instances
        Package_c container = Package_c.getOneEP_PKGOnR1401(m_sys, new ClassQueryInterface_c() {
            
            @Override
            public boolean evaluate(Object candidate) {
                return ((Package_c) candidate).getName().equals("Container");
            }
        });
        Selection.getInstance().clear(); Selection.getInstance().addToSelection(container);
        ParseAllActivitiesAction action = new ParseAllActivitiesAction();
        action.run(null);
        // configure flag for existance of implementation of auto complete
        try {
            if(Class.forName("org.xtuml.bp.core.Proposal_c") == null) {
                implementationExists = false;
            }
        } catch (ClassNotFoundException e) {
            implementationExists = false;
        }

        if ( implementationExists ) {
            // set up reflection API for computing proposals
            Class<?> processorClass = Class.forName( "org.xtuml.bp.ui.text.contentassist.OALCompletionProcessor" );
            Class<?> proposalClass = Class.forName( "org.xtuml.bp.ui.text.contentassist.OALCompletionProposal" );
            setUpMethod = processorClass.getMethod( "setUp" );
            computeMethod = processorClass.getMethod( "computeCompletionProposals", IDocument.class, NonRootModelElement.class, int.class );
            cleanUpMethod = processorClass.getMethod( "cleanUp", NonRootModelElement.class );
            getReplacementTextMethod = proposalClass.getMethod( "getReplacementString" );
            processor = processorClass.newInstance();
            
            Class<?> docUtil = Class.forName( "org.xtuml.bp.core.util.DocumentUtil" );
            lineAndColumnToPosition = docUtil.getMethod( "lineAndColumnToPosition", int.class, int.class, IDocument.class );
            positionToLine = docUtil.getMethod( "positionToLine", int.class, IDocument.class );
        }
    };

    @After
    public void tearDown() throws Exception {
        Ooaofooa.enableChangeNotification();
    }

    /**
     * "LPAH" is one of the degrees of freedom as specified in this issues
     * test matrix.
     * This routine gets the "LPAH" instance from the given name.
     * 
     * @param element The degree of freedom instance to retrieve
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectLPAH(String element) {
        return selectLPAH(element, null);
    }

    /**
     * "LPAH" is one of the degrees of freedom as specified in this issues
     * test matrix.
     * This routine gets the "LPAH" instance from the given name.
     * 
     * @param element The degree of freedom instance to retrieve
     * @param extraData Extra data needed for selection
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectLPAH(String element, Object extraData) {
        return findElementForDof(element);
    }

    private int getLineNumber(String element) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	element = getEntryFromString( element, "S" );
        NonRootModelElement rootElement = (NonRootModelElement) getRootElementForBody(testBody)[0];
        String action = ActionLanguageDescriptionUtil.getActionLanguageAttributeValue(rootElement);
        Document doc = new Document(action);
        return (int)positionToLine.invoke( null, action.indexOf("insert test oal " + element), doc );
    }

    private String getLocationText() {
        String element = getEntryFromString(getName(), "L");
        if(element.equals("L02")) {
            return "l2_var.";
        } else if(element.equals("L03")) {
            return "::";
        } else if(element.equals("L04")) {
            return "send";
        } else if(element.equals("L05")) {
            return "send L33::";
        } else if(element.equals("L06")) {
            return "send L33::signal( sig_parameter:1 ) to";
        } else if(element.equals("L07")) {
            return "select one l7_var_one";
        } else if(element.equals("L08")) {
            return "select one l8_var_one related by l8_var_two->";
        } else if(element.equals("L09")) {
            return "select one l9_var from instances of ";
        } else if(element.equals("L10")) {
            return "select one l9_var from instances of L19 ";
        } else if(element.equals("L11")) {
            return "generate";
        } else if(element.equals("L12")) {
            return "generate L11Class1:event to";
        } else if(element.equals("L13")) {
            return "generate L11Class2:event2 to";
        } else if(element.equals("L14")) {
            return "generate L11Class_A1:event to";
        } else if(element.equals("L15")) {
            return "p12_var =";
        } else if(element.equals("L16")) {
            return "for each l13_var in";
        } else if(element.equals("L17")) {
            return "return";
        } else if(element.equals("L18")) {
            return "relate";
        } else if(element.equals("L19")) {
            return "relate l16_var to";
        } else if(element.equals("L20")) {
            return "relate l17_var to l17_var_2 across";
        } else if(element.equals("L21")) {
            return "relate l18_var to l18_var_2 across R1.";
        } else if(element.equals("L22")) {
            return "relate l19_var to l19_var_other across R2 using";
        } else if(element.equals("L23")) {
            return "unrelate ";
        } else if(element.equals("L24")) {
            return "unrelate l20_var from";
        } else if(element.equals("L25")) {
            return "unrelate l21_var from l21_var_2 across";
        } else if(element.equals("L26")) {
            return "unrelate l22_var from l22_var_2 across R1.";
        } else if(element.equals("L27")) {
            return "unrelate l23_var from l23_other across R2 using";
        } else if(element.equals("L28")) {
            return "self.";
        } else if(element.equals("L29")) {
            return "card_var = cardinality ";
        } else if(element.equals("L30")) {
            return "ne_var = not_empty ";
        } else if(element.equals("L31")) {
            return "param.";
        } else if(element.equals("L32")) {
            return "create object instance l28_var of";
        } else if(element.equals("L33")) {
            return "delete object instance";
        } else if(element.equals("L34")) {
            return "if(";
        } else if(element.equals("L35")) {
            return "create event instance l31_var of";
        } else if(element.equals("L36")) {
            return "create event instance l32_var of L11Class1 to";
        } else if(element.equals("L37")) {
            return "invocation_return = L33::";
        }
        return " ";
    }
    
    // example name: testS1V1_L1P21AH3
    private String getEntryFromString(String string, String result) {
        int s_index = string.indexOf("S");
        int v_index = string.indexOf("V");
        int _index = string.indexOf("_");
        int l_index = string.indexOf("L");
        int p_index = string.indexOf("P");
        int ah_index = string.indexOf("AH");
        CharSequence s_sequence = string.subSequence(s_index, v_index);
        CharSequence v_sequence = string.subSequence(v_index, _index);
        CharSequence l_sequence = string.subSequence(l_index, p_index);
        CharSequence p_sequence = string.subSequence(p_index, ah_index);
        CharSequence ah_sequence = string.subSequence(ah_index, string.length());
        if ( "S".equals( result ) ) {
            return s_sequence.toString();
        }
        else if ( "V".equals( result ) ) {
            return v_sequence.toString();
        }
        else if ( "L".equals( result ) ) {
            return l_sequence.toString();
        }
        else if ( "P".equals( result ) ) {
            return p_sequence.toString();
        }
        else if ( "AH".equals( result ) ) {
            return ah_sequence.toString();
        }
        else {
            return null;
        }
    }

    private String[] getPossibilities(String element) {
        String location = getEntryFromString(element, "L");
        String actionhome = getEntryFromString(element, "AH");
        String visibility = getEntryFromString(element, "V");
        element = getEntryFromString(element, "P");
        String[] possibilities = new String[0];
        if(element.equals("P01")) {
            possibilities = new String[] {"control stop"};
        } else if (element.equals("P02")) {
            possibilities = new String[] {"create event instance"};
        } else if (element.equals("P03")) {
            possibilities = new String[] {"create object instance"};
        } else if (element.equals("P04")) {
            possibilities = new String[] {"delete object instance"};
        } else if (element.equals("P05")) {
            possibilities = new String[] {"for each"};
        } else if (element.equals("P06")) {
            possibilities = new String[] {"generate"};
        } else if (element.equals("P07")) {
            possibilities = new String[] {"if"};
        } else if (element.equals("P08")) {
            possibilities = new String[] {"param"};
        } else if (element.equals("P09")) {
            possibilities = new String[] {"relate"};
        } else if (element.equals("P10")) {
            possibilities = new String[] {"return"};
        } else if (element.equals("P11")) {
            possibilities = new String[] {"select any"};
        } else if (element.equals("P12")) {
            possibilities = new String[] {"select many"};
        } else if (element.equals("P13")) {
            possibilities = new String[] {"select one"};
        } else if (element.equals("P14")) {
            possibilities = new String[] {"send"};
        } else if (element.equals("P15")) {
            possibilities = new String[] {"unrelate"};
        } else if (element.equals("P16")) {
            possibilities = new String[] {"while"};
        } else if (element.equals("P17")) {
            possibilities = new String[] {"break"};
        } else if (element.equals("P18")) {
            possibilities = new String[] {"continue"};
        } else if (element.equals("P19")) {
            possibilities = new String[] {"end while"};
        } else if (element.equals("P20")) {
            possibilities = new String[] {"end for"};
        } else if (element.equals("P21")) {
            possibilities = new String[] {"elif"};
        } else if (element.equals("P22")) {
            possibilities = new String[] {"else"};
        } else if (element.equals("P23")) {
            possibilities = new String[] {"end if"};
        } else if (element.equals("P24")) {
            possibilities = new String[] {"self"};
        }  else if (element.equals("P25")) {
            possibilities = new String[] { "x" };
        } else if (element.equals("P26")) {
            possibilities = new String[] {"L33::"};
        } else if (element.equals("P27")) {
        	if ( location.equals("L09") || location.equals("L32") ) {
        		possibilities = new String[] {"Class1","Class2","Class3","Class4","L11Class","L19","L19_link",
        				             "L19_other","L2Class","L8Class","L8Class_two","L33","L6Class"};
        	}
        	else {
                possibilities = new String[] {"L33::"};
        	}
        } else if (element.equals("P28")) {
            possibilities = new String[] {"Port1::", "L33::"};
        } else if (element.equals("P29")) {
            possibilities = new String[] {"attribute"};
        } else if (element.equals("P30")) {
            possibilities = new String[] {"operation( parameter: )"};
        } else if (element.equals("P31")) {
            possibilities = new String[] {"cb_operation( parameter: )"};
        } else if (element.equals("P32")) {
            possibilities = new String[] {"function( parameter: )", "FunctionOne()", "FunctionOne-Parameters( ParameterOne:, ParameterTwo:, ParameterThree: )", "FunctionTwo()", "FunctionTwo-Parameters( ParameterOne:, ParameterTwo:, ParameterThree: )"};
        } else if (element.equals("P33")) {
        	if ( actionhome.equals("AH06") || actionhome.equals("AH08") ) {
                possibilities = new String[] {"op_parameter"};
        	}
        	else if ( actionhome.equals("AH07") || actionhome.equals("AH09") ) {
                possibilities = new String[] {"sig_parameter"};
        	}
        	else {
                possibilities = new String[] {"parameter"};
        	}
        } else if (element.equals("P34")) {
            possibilities = new String[] {"R1.'formalizer'"};
        } else if (element.equals("P35")) {
            possibilities = new String[] {"'formalizer'"};
        } else if (element.equals("P36")) {
            possibilities = new String[] {"L11Class creator"};
        } else if (element.equals("P37")) {
            possibilities = new String[] {"L11Class class"};
        } else if (element.equals("P38")) {
            possibilities = new String[] {"l11_inst_event"};
        } else if (element.equals("P39")) {
            possibilities = new String[] {"where"};
        } else if (element.equals("P40")) {
            possibilities = new String[] {"cardinality"};
        } else if (element.equals("P41")) {
            possibilities = new String[] {"empty"};
        } else if (element.equals("P42")) {
            possibilities = new String[] {"not"};
        } else if (element.equals("P43")) {
            possibilities = new String[] { "l2_var", "l8_var_one", "l8_var_two", "l11_var",
                    "l16_var", "l16_var_2", "l17_var", "l17_var_2", "l18_var", "l18_var_2", "l19_var", "l19_var_other",
                    "l19_var_link", "l20_var", "l20_var_2", "l21_var", "l21_var_2", "l22_var", "l22_var_2", "l23_var",
                    "l23_other", "l23_link", "l6class" };
        } else if (element.equals("P44")) {
            possibilities = new String[] {"l13_vars"};
        } else if (element.equals("P45")) {
            possibilities = new String[] {"not_empty"};
        } else if (element.equals("P46")) {
            possibilities = new String[] {"true"};
        } else if (element.equals("P47")) {
            possibilities = new String[] {"false"};
        } else if (element.equals("P48")) {
            possibilities = new String[] {"operation( op_parameter: )", "signal( sig_parameter: )"};
        } else if (element.equals("P49")) {
            possibilities = new String[] {"comp_ref_var"};
        } else if (element.equals("P50")) {
            possibilities = new String[] {"sender"};
        } else if (element.equals("P51")) {
            possibilities = new String[] {"related by"};
        } else if (element.equals("P52")) {
            possibilities = new String[] {"from instances of"};
        } else if (element.equals("P53")) {
            possibilities = new String[] {"Class11:event( parameter: )", "Class12:creation()", "Class21:event( parameter: )", "L11Class1:event()", "L11Class_A1:event()"};
        } else if (element.equals("P54")) {
            possibilities = new String[] {"const1", "const2"};
        } else if (element.equals("P55")) {
            possibilities = new String[] {"enum1", "enum2"};
        } else if (element.equals("P56")) {
            possibilities = new String[] {"L33::", "EDT2::"};
        } else if (element.equals("P57")) {
            possibilities = new String[] {"bridge( parameter: )"};
        } else if (element.equals("P58")) {
            possibilities = new String[] {"->L8Class[R1.'simple']"};
        }
        if ( visibility.equals("V2") ) {
        	for ( int i = 0; i < possibilities.length; i++ ) {
        		possibilities[i] = "invisible_" + possibilities[i]; // prepend with 'invisible_'
        	}
        }
        return possibilities;
    }

    private String[] populateAutoComplete(String element) throws BadLocationException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        NonRootModelElement rootElement = (NonRootModelElement) getRootElementForBody(testBody)[0];
        int lineNumber = getLineNumber(element);
        String locationText = getLocationText();
        String action = ActionLanguageDescriptionUtil.getActionLanguageAttributeValue(rootElement);
        Document doc = new Document(action);
        IRegion region = doc.getLineInformation(lineNumber-1);
        doc.replace(region.getOffset(), region.getLength(), locationText);
        setUpMethod.invoke( processor );
        Object[] proposals = (Object[]) computeMethod.invoke( processor, doc, rootElement, (int)lineAndColumnToPosition.invoke( null, lineNumber, locationText.length() + 1, doc ) );
        String[] results = new String[proposals.length];
        for(int i = 0; i < results.length; i++) {
            results[i] = ((String)getReplacementTextMethod.invoke( proposals[i] )).trim();
        }
        cleanUpMethod.invoke( processor, rootElement );
        return results;
    }

    public static Object[] getRootElementForBody(NonRootModelElement columnInstance) {
        NonRootModelElement element = Bridge_c.getOneS_BRGOnR697(BridgeBody_c.getManyACT_BRBsOnR698((Body_c) columnInstance));
        if (element == null) {
            element = Operation_c.getOneO_TFROnR696((OperationBody_c.getManyACT_OPBsOnR698((Body_c) columnInstance)));
        }
        if(element == null) {
            element = Action_c.getOneSM_ACTOnR691(StateActionBody_c.getManyACT_SABsOnR698((Body_c) columnInstance));
        } 
        if(element == null) {
            element = Function_c.getOneS_SYNCOnR695(FunctionBody_c.getManyACT_FNBsOnR698((Body_c) columnInstance));
        } 
        if(element == null) {
            element = DerivedBaseAttribute_c.getOneO_DBATTROnR693(DerivedAttributeBody_c.getManyACT_DABsOnR698((Body_c) columnInstance));
        } 
        if(element == null) {
            element = ProvidedOperation_c.getOneSPR_POOnR687(ProvidedOperationBody_c.getManyACT_POBsOnR698((Body_c) columnInstance));
        } 
        if (element == null) {
            element = ProvidedSignal_c.getOneSPR_PSOnR686(ProvidedSignalBody_c.getManyACT_PSBsOnR698((Body_c) columnInstance));
        } 
        if (element == null) {
            element = RequiredOperation_c.getOneSPR_ROOnR685(RequiredOperationBody_c.getManyACT_ROBsOnR698((Body_c) columnInstance));
        } 
        if (element == null) {
            element = RequiredSignal_c.getOneSPR_RSOnR684(RequiredSignalBody_c.getManyACT_RSBsOnR698((Body_c) columnInstance));
        } 
        if (element == null) {
            element = Action_c.getOneSM_ACTOnR688(TransitionActionBody_c.getManyACT_TABsOnR698((Body_c) columnInstance));
        }
        String action = ActionLanguageDescriptionUtil.getActionLanguageAttributeValue(element);
        return new Object[] { element, action };
    }

    Body_c testBody = null;
    private String[] actualProposals;
    NonRootModelElement findElementForDof(String element) {
        ClassQueryInterface_c classQuery = new ClassQueryInterface_c() {

            @Override
            public boolean evaluate(Object candidate) {
                // ignore empty bodies
                Object[] detail = getBodyDetail((Body_c) candidate);
                NonRootModelElement pkg = (Package_c) detail[0];
                String action = (String) detail[1];
                if(action.length() == 0) {
                    return false;
                }
                int index = getName().indexOf("AH");
                int length = getName().length();
                CharSequence testSequence = getName().subSequence(index, length);
                index = pkg.getName().indexOf("AH");
                if(index != -1) {
                    length = pkg.getName().length();
                    CharSequence pkgSequence = pkg.getName().subSequence(index, length);            
                    if ( pkgSequence.toString().contains("AH10") ) {
                        TransitionActionBody_c act_tab = TransitionActionBody_c.getOneACT_TABOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_tab;
                    }
                    else if ( pkgSequence.toString().contains("AH01") ) {
                        StateActionBody_c act_sab = StateActionBody_c.getOneACT_SABOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_sab;
                    }
                    else if ( pkgSequence.toString().contains("AH02") ) {
                        DerivedAttributeBody_c act_dab = DerivedAttributeBody_c.getOneACT_DABOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_dab;
                    }
                    else if ( pkgSequence.toString().contains("AH03") ) {
                        FunctionBody_c act_fnb = FunctionBody_c.getOneACT_FNBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_fnb;
                    }
                    else if ( pkgSequence.toString().contains("AH04") ) {
                        OperationBody_c act_opb = OperationBody_c.getOneACT_OPBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_opb;
                    }
                    else if ( pkgSequence.toString().contains("AH05") ) {
                        BridgeBody_c act_brb = BridgeBody_c.getOneACT_BRBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_brb;
                    }
                    else if ( pkgSequence.toString().contains("AH06") ) {
                        ProvidedOperationBody_c act_pob = ProvidedOperationBody_c.getOneACT_POBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_pob;
                    }
                    else if ( pkgSequence.toString().contains("AH07") ) {
                        ProvidedSignalBody_c act_psb = ProvidedSignalBody_c.getOneACT_PSBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_psb;
                    }
                    else if ( pkgSequence.toString().contains("AH08") ) {
                        RequiredOperationBody_c act_rob = RequiredOperationBody_c.getOneACT_ROBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_rob;
                    }
                    else if ( pkgSequence.toString().contains("AH09") ) {
                        RequiredSignalBody_c act_rsb = RequiredSignalBody_c.getOneACT_RSBOnR698((Body_c)candidate);
                        return testSequence.equals(pkgSequence) && null != act_rsb;
                    }
                    else return testSequence.equals(pkgSequence);
                }
                return false;
            }
        };
        testBody = Body_c.BodyInstance(modelRoot, classQuery);
        return testBody;
    }
    protected Object[] getBodyDetail(Body_c body) {
        Object[] bodyDetail = getRootElementForBody(body);
        NonRootModelElement root = (NonRootModelElement) bodyDetail[0];
        Package_c parentPackage = root.getFirstParentPackage();
        if(parentPackage == null) {
            Component_c parentComponent = root.getFirstParentComponent();
            if(parentComponent != null) {
                parentPackage = parentComponent.getFirstParentPackage();
            }
        }
        bodyDetail[0] = parentPackage;
        return bodyDetail;
    }

    /**
     * "SV" is one of the degrees of freedom as specified in this issues
     * test matrix.
     * This routine gets the "SV" instance from the given name.
     * 
     * @param element The degree of freedom instance to retrieve
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectSV(String element) {
        return selectSV(element, null);
    }

    /**
     * "SV" is one of the degrees of freedom as specified in this issues
     * test matrix.
     * This routine gets the "SV" instance from the given name.
     * 
     * @param element The degree of freedom instance to retrieve
     * @param extraData Extra data needed for selection
     * @return A model element used in the test as specified by the test matrix
     */
    NonRootModelElement selectSV(String element, Object extraData) {
        // everything will be selected in the PAH selection, and test run
        return null;
    }

    /**
     * This routine performs the action associated with a matrix cell.
     * The parameters represent model instances aquired based on the specifed
     * column instance and row instance.
     * 
     * @param columnInstance Model instance from the column
     * @param rowInstance Model instance from the row
     * @throws BadPositionCategoryException 
     * @throws BadLocationException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws ClassNotFoundException 
     */
    void SV_LPAH_Action(NonRootModelElement columnInstance, NonRootModelElement rowInstance) throws BadLocationException, BadPositionCategoryException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        actualProposals = populateAutoComplete(getName());
    }

    /**
    * This function verifies an expected result.
    *
    * @param source A model element instance aquired through a action taken
    *               on a column of the matrix.
    * @param destination A model element instance aquired through a action taken
    *                    taken on a row of the matrix.
    * @return true if the test succeeds, false if it fails
    */
    boolean checkResult_doesNotExist(NonRootModelElement source, NonRootModelElement destination) {
        String[] possibilities = getPossibilities(getName());
        // make sure no possibility is present
        for(String possibility : possibilities) {
            for(String actual : actualProposals) {
                if(actual.equals(possibility)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
    * This function verifies an expected result.
    *
    * @param source A model element instance aquired through a action taken
    *               on a column of the matrix.
    * @param destination A model element instance aquired through a action taken
    *                    taken on a row of the matrix.
    * @return true if the test succeeds, false if it fails
    */
    boolean checkResult_doesExist(NonRootModelElement source, NonRootModelElement destination) {
        String[] possibilities = getPossibilities(getName());
        // make sure every possibility is present
        int num_possibilities_present = 0;
        for(String possibility : possibilities) {
            for(String actual : actualProposals) {
                if(actual.equals(possibility)) {
                    num_possibilities_present++;
                    break;
                }
            }
        }
        return ( num_possibilities_present == possibilities.length );
    }


}
