//=====================================================================
//
// NOTE: This file was generated, but is maintained by hand.
// Generated by: UnitTestGenerator.pl
// Version:      1.15
// Matrix:       9761_9762_find_declarations_matrix.txt
//
//=====================================================================

package org.xtuml.bp.ui.text.test.opendeclarations;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.xtuml.bp.core.ActionHome_c;
import org.xtuml.bp.core.Action_c;
import org.xtuml.bp.core.Attribute_c;
import org.xtuml.bp.core.BaseAttribute_c;
import org.xtuml.bp.core.Body_c;
import org.xtuml.bp.core.BridgeBody_c;
import org.xtuml.bp.core.BridgeParameter_c;
import org.xtuml.bp.core.Bridge_c;
import org.xtuml.bp.core.Component_c;
import org.xtuml.bp.core.DerivedAttributeBody_c;
import org.xtuml.bp.core.DerivedBaseAttribute_c;
import org.xtuml.bp.core.EventSupplementalData_c;
import org.xtuml.bp.core.ExecutableProperty_c;
import org.xtuml.bp.core.ExternalEntity_c;
import org.xtuml.bp.core.FunctionBody_c;
import org.xtuml.bp.core.FunctionParameter_c;
import org.xtuml.bp.core.Function_c;
import org.xtuml.bp.core.InstanceStateMachine_c;
import org.xtuml.bp.core.InterfaceOperation_c;
import org.xtuml.bp.core.InterfaceReference_c;
import org.xtuml.bp.core.InterfaceSignal_c;
import org.xtuml.bp.core.ModelClass_c;
import org.xtuml.bp.core.MooreActionHome_c;
import org.xtuml.bp.core.NewStateTransition_c;
import org.xtuml.bp.core.Ooaofooa;
import org.xtuml.bp.core.OperationBody_c;
import org.xtuml.bp.core.OperationParameter_c;
import org.xtuml.bp.core.Operation_c;
import org.xtuml.bp.core.Package_c;
import org.xtuml.bp.core.PackageableElement_c;
import org.xtuml.bp.core.Port_c;
import org.xtuml.bp.core.PropertyParameter_c;
import org.xtuml.bp.core.ProvidedExecutableProperty_c;
import org.xtuml.bp.core.ProvidedOperationBody_c;
import org.xtuml.bp.core.ProvidedOperation_c;
import org.xtuml.bp.core.ProvidedSignalBody_c;
import org.xtuml.bp.core.ProvidedSignal_c;
import org.xtuml.bp.core.Provision_c;
import org.xtuml.bp.core.RequiredExecutableProperty_c;
import org.xtuml.bp.core.RequiredOperationBody_c;
import org.xtuml.bp.core.RequiredOperation_c;
import org.xtuml.bp.core.RequiredSignalBody_c;
import org.xtuml.bp.core.RequiredSignal_c;
import org.xtuml.bp.core.Requirement_c;
import org.xtuml.bp.core.SemEvent_c;
import org.xtuml.bp.core.StateActionBody_c;
import org.xtuml.bp.core.StateEventMatrixEntry_c;
import org.xtuml.bp.core.StateMachineEventDataItem_c;
import org.xtuml.bp.core.StateMachineEvent_c;
import org.xtuml.bp.core.StateMachineState_c;
import org.xtuml.bp.core.StateMachine_c;
import org.xtuml.bp.core.SupplementalDataItems_c;
import org.xtuml.bp.core.TransitionActionBody_c;
import org.xtuml.bp.core.TransitionActionHome_c;
import org.xtuml.bp.core.Transition_c;
import org.xtuml.bp.core.common.ClassQueryInterface_c;
import org.xtuml.bp.core.common.NonRootModelElement;
import org.xtuml.bp.core.ui.Selection;
import org.xtuml.bp.core.util.ActionLanguageDescriptionUtil;
import org.xtuml.bp.test.common.CanvasEditorUtils;
import org.xtuml.bp.test.common.CanvasTestUtils;
import org.xtuml.bp.ui.canvas.test.CanvasTest;
import org.xtuml.bp.ui.graphics.editor.GraphicalEditor;
import org.xtuml.bp.ui.text.activity.ActivityEditor;
import org.xtuml.bp.ui.text.activity.OpenDeclarationAction;
import org.xtuml.bp.ui.text.activity.ParseAllActivitiesAction;

import junit.framework.TestCase;

public class OpenDeclarationsTests extends CanvasTest {
	public static boolean generateResults = false;
	public static boolean useDrawResults = true;

	String test_id = "";

	protected String getResultName() {
		return getClass().getSimpleName() + "_" + test_id;
	}

	protected GraphicalEditor fActiveEditor;
	private NonRootModelElement testBody;
	private Object testElement;
	private NonRootModelElement activityElement;
	private Document testDocument;

	protected GraphicalEditor getActiveEditor() {
		return fActiveEditor;
	}

	public OpenDeclarationsTests(String subTypeClassName, String subTypeArg0) {
		super(null, subTypeArg0);
	}

	protected String getTestId(String src, String dest, String count) {
		return "test_" + count;
	}

	@Override
	protected void initialSetup() throws Exception {
		loadProject("oal_open_declarations");
		m_sys = getSystemModel("oal_open_declarations");
		modelRoot = Ooaofooa
				.getInstance("/oal_open_declarations/models/oal_open_declarations/MainPackage/MainPackage.xtuml");
		Selection.getInstance().setSelection(new StructuredSelection(Package_c.getOneEP_PKGOnR1401(m_sys)));
		ParseAllActivitiesAction action = new ParseAllActivitiesAction();
		action.run(null);
	};

	@Before
	public void setUp() throws Exception {
		super.setUp();
		setupTestBody();
		testDocument = new Document(ActionLanguageDescriptionUtil.getActionLanguageAttributeValue(activityElement));
		testElement = getTestElement();
		assertNotNull("Could not locate test element.", testElement);
		// open the editor for the test oal
		CanvasTestUtils.openActivityEditor(activityElement);
	}

	// example of test name: testT01L01_E01P01M01C01
	private Object getTestElement() {
		String name = getName();
		String t = name.substring(4, 7);
		String row = name.split("_")[1];
		String e = row.substring(0, 2);
		switch (t) {
		case "T01":
			// return the first Variable location as offset
			String document = testDocument.get();
			return document.indexOf(t + e);
		case "T02":
			return ModelClass_c.ModelClassInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((ModelClass_c) candidate).getName().equals(t + e);
				}
			});
		case "T03":
			return Function_c.FunctionInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((Function_c) candidate).getName().equals(t + e);
				}
			});
		case "T04":
			return ExternalEntity_c.ExternalEntityInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((ExternalEntity_c) candidate).getName().equals(t + e);
				}
			});
		case "T05":
			return Port_c.PortInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((Port_c) candidate).getName().equals(t + e);
				}
			});
		case "T06":
			return StateMachineEvent_c.StateMachineEventInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((StateMachineEvent_c) candidate).getMning().equals(t + e);
				}
			});
		case "T07":
			return Operation_c.OperationInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((Operation_c) candidate).getName().equals(t + e);
				}
			});
		case "T08":
			return Bridge_c.BridgeInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((Bridge_c) candidate).getName().equals(t + e);
				}
			});
		case "T09":
			return InterfaceOperation_c.InterfaceOperationInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((InterfaceOperation_c) candidate).getName().equals(t + e);
				}
			});
		case "T10":
			return InterfaceSignal_c.InterfaceSignalInstance(modelRoot, new ClassQueryInterface_c() {

				@Override
				public boolean evaluate(Object candidate) {
					return ((InterfaceSignal_c) candidate).getName().equals(t + e);
				}
			});
		case "T11":
			if (activityElement instanceof Operation_c) {
				return OperationParameter_c.getOneO_TPARMOnR117((Operation_c) activityElement);
			}
			if (activityElement instanceof Bridge_c) {
				return BridgeParameter_c.getOneS_BPARMOnR21((Bridge_c) activityElement);
			}
			if (activityElement instanceof Function_c) {
				return FunctionParameter_c.getOneS_SPARMOnR24((Function_c) activityElement);
			}
			if (activityElement instanceof ProvidedSignal_c) {
				PropertyParameter_c pp = PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4501(
						ProvidedExecutableProperty_c.getManySPR_PEPsOnR4503((ProvidedSignal_c) activityElement)));
				return pp;
			}
			if (activityElement instanceof ProvidedOperation_c) {
				PropertyParameter_c pp = PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4501(
						ProvidedExecutableProperty_c.getManySPR_PEPsOnR4503((ProvidedOperation_c) activityElement)));
				return pp;
			}
			if (activityElement instanceof RequiredSignal_c) {
				PropertyParameter_c pp = PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4500(
						RequiredExecutableProperty_c.getManySPR_REPsOnR4502((RequiredSignal_c) activityElement)));
				return pp;
			}
			if (activityElement instanceof RequiredOperation_c) {
				PropertyParameter_c pp = PropertyParameter_c.getOneC_PPOnR4006(ExecutableProperty_c.getManyC_EPsOnR4500(
						RequiredExecutableProperty_c.getManySPR_REPsOnR4502((RequiredOperation_c) activityElement)));
				return pp;
			}
			if (activityElement instanceof Transition_c) {
				StateMachineEventDataItem_c smedi = StateMachineEventDataItem_c.getOneSM_EVTDIOnR522(
						SupplementalDataItems_c.getManySM_SDIsOnR522(EventSupplementalData_c.getManySM_SUPDTsOnR520(
								StateMachineEvent_c.getManySM_EVTsOnR525(SemEvent_c.getManySM_SEVTsOnR503(
										StateEventMatrixEntry_c.getManySM_SEMEsOnR504(NewStateTransition_c
												.getManySM_NSTXNsOnR507((Transition_c) activityElement)))))));
				return smedi;
			}
			if (activityElement instanceof StateMachineState_c) {
				StateMachineEventDataItem_c smedi = StateMachineEventDataItem_c.getOneSM_EVTDIOnR522(SupplementalDataItems_c
						.getManySM_SDIsOnR522(EventSupplementalData_c.getManySM_SUPDTsOnR520(StateMachineEvent_c
								.getManySM_EVTsOnR525(SemEvent_c.getManySM_SEVTsOnR503(StateEventMatrixEntry_c
										.getManySM_SEMEsOnR503((StateMachineState_c) activityElement))))));
				return smedi;
			}
		case "T12":
			// return an association
		case "T13":
			// return an attribute
			document = testDocument.get();
			return document.indexOf(t + e);
		default:
			break;
		}
		return null;
	}

	// example of test name: testT01L01_E01P01M01C01
	private void setupTestBody() {
		Package_c mainPackage = Package_c.getOneEP_PKGOnR1401(m_sys);
		// first extract the L, and open the body for it
		String name = getName();
		String l = name.substring(7, 10);
		ModelClass_c modelClass = ModelClass_c.getOneO_OBJOnR8001(
				PackageableElement_c.getManyPE_PEsOnR8000(mainPackage), new ClassQueryInterface_c() {

					@Override
					public boolean evaluate(Object candidate) {
						return ((ModelClass_c) candidate).getName().equals(l);
					}
				});
		Component_c component = Component_c.getOneC_COnR8001(PackageableElement_c.getManyPE_PEsOnR8000(mainPackage),
				new ClassQueryInterface_c() {

					@Override
					public boolean evaluate(Object candidate) {
						return ((Component_c) candidate).getName().equals(l);
					}
				});
		switch (l) {
		case "L01":
			RequiredSignal_c rs = RequiredSignal_c.getOneSPR_RSOnR4502(
					RequiredExecutableProperty_c.getManySPR_REPsOnR4500(Requirement_c.getManyC_RsOnR4009(
							InterfaceReference_c.getManyC_IRsOnR4016(Port_c.getManyC_POsOnR4010(component)))));
			activityElement = rs;
			testBody = Body_c.getOneACT_ACTOnR698(RequiredSignalBody_c.getOneACT_RSBOnR684(rs));
			break;
		case "L02":
			RequiredOperation_c ro = RequiredOperation_c.getOneSPR_ROOnR4502(
					RequiredExecutableProperty_c.getManySPR_REPsOnR4500(Requirement_c.getManyC_RsOnR4009(
							InterfaceReference_c.getManyC_IRsOnR4016(Port_c.getManyC_POsOnR4010(component)))));
			activityElement = ro;
			testBody = Body_c.getOneACT_ACTOnR698(RequiredOperationBody_c.getOneACT_ROBOnR685(ro));
			break;
		case "L03":
			ProvidedSignal_c ps = ProvidedSignal_c.getOneSPR_PSOnR4503(
					ProvidedExecutableProperty_c.getManySPR_PEPsOnR4501(Provision_c.getManyC_PsOnR4009(
							InterfaceReference_c.getManyC_IRsOnR4016(Port_c.getManyC_POsOnR4010(component)))));
			activityElement = ps;
			testBody = Body_c.getOneACT_ACTOnR698(ProvidedSignalBody_c.getOneACT_PSBOnR686(ps));
			break;
		case "L04":
			ProvidedOperation_c po = ProvidedOperation_c.getOneSPR_POOnR4503(
					ProvidedExecutableProperty_c.getManySPR_PEPsOnR4501(Provision_c.getManyC_PsOnR4009(
							InterfaceReference_c.getManyC_IRsOnR4016(Port_c.getManyC_POsOnR4010(component)))));
			activityElement = po;
			testBody = Body_c.getOneACT_ACTOnR698(ProvidedOperationBody_c.getOneACT_POBOnR687(po));
			break;
		case "L05":
			Transition_c transition = Transition_c.getOneSM_TXNOnR505(
					StateMachine_c.getManySM_SMsOnR517(InstanceStateMachine_c.getManySM_ISMsOnR518(modelClass)));
			activityElement = transition;
			testBody = Body_c.getOneACT_ACTOnR698(
					TransitionActionBody_c.getManyACT_TABsOnR688(Action_c.getManySM_ACTsOnR514(ActionHome_c
							.getManySM_AHsOnR513(TransitionActionHome_c.getManySM_TAHsOnR530(transition)))));
			break;
		case "L06":
			StateMachineState_c state = StateMachineState_c.getOneSM_STATEOnR501(
					StateMachine_c.getManySM_SMsOnR517(InstanceStateMachine_c.getManySM_ISMsOnR518(modelClass)));
			activityElement = state;
			testBody = Body_c.getOneACT_ACTOnR698(StateActionBody_c.getManyACT_SABsOnR691(Action_c.getManySM_ACTsOnR514(
					ActionHome_c.getManySM_AHsOnR513(MooreActionHome_c.getManySM_MOAHsOnR511(state)))));
			break;
		case "L07":
			DerivedBaseAttribute_c dba = DerivedBaseAttribute_c.getOneO_DBATTROnR107(
					BaseAttribute_c.getManyO_BATTRsOnR106(Attribute_c.getManyO_ATTRsOnR102(modelClass)));
			activityElement = dba;
			testBody = Body_c.getOneACT_ACTOnR698(DerivedAttributeBody_c.getManyACT_DABsOnR693(dba));
			break;
		case "L08":
			Function_c function = Function_c.getOneS_SYNCOnR8001(PackageableElement_c.getManyPE_PEsOnR8000(mainPackage),
					new ClassQueryInterface_c() {

						@Override
						public boolean evaluate(Object candidate) {
							return ((Function_c) candidate).getName().equals(l);
						}
					});
			activityElement = function;
			testBody = Body_c.getOneACT_ACTOnR698(FunctionBody_c.getManyACT_FNBsOnR695(function));
			break;
		case "L09":
			Operation_c operation = Operation_c.getOneO_TFROnR115(
					ModelClass_c.getManyO_OBJsOnR8001(PackageableElement_c.getManyPE_PEsOnR8000(mainPackage)));
			activityElement = operation;
			testBody = Body_c.getOneACT_ACTOnR698(OperationBody_c.getManyACT_OPBsOnR696(operation));
			break;
		case "L10":
			Bridge_c bridge = Bridge_c.getOneS_BRGOnR19(ExternalEntity_c.getManyS_EEsOnR8001(
					PackageableElement_c.getManyPE_PEsOnR8000(mainPackage), new ClassQueryInterface_c() {

						@Override
						public boolean evaluate(Object candidate) {
							return ((ExternalEntity_c) candidate).getName().equals(l);
						}
					}));
			activityElement = bridge;
			testBody = Body_c.getOneACT_ACTOnR698(BridgeBody_c.getManyACT_BRBsOnR697(bridge));
			break;
		default:
			break;
		}
	}

	@After
	public void tearDown() throws Exception {
		// close all editors
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		super.tearDown();
	}

	/**
	 * "TL" is one of the degrees of freedom as specified in this issues test
	 * matrix. This routine gets the "TL" instance from the given name.
	 * 
	 * @param element
	 *            The degree of freedom instance to retrieve
	 * @return A model element used in the test as specified by the test matrix
	 */
	NonRootModelElement selectTL(String element) {
		return selectTL(element, null);
	}

	/**
	 * "TL" is one of the degrees of freedom as specified in this issues test
	 * matrix. This routine gets the "TL" instance from the given name.
	 * 
	 * @param element
	 *            The degree of freedom instance to retrieve
	 * @param extraData
	 *            Extra data needed for selection
	 * @return A model element used in the test as specified by the test matrix
	 */
	NonRootModelElement selectTL(String element, Object extraData) {
		// not necessary as the test elements are configured during
		// setup
		return null;
	}

	/**
	 * "EPMC" is one of the degrees of freedom as specified in this issues test
	 * matrix. This routine gets the "EPMC" instance from the given name.
	 * 
	 * @param element
	 *            The degree of freedom instance to retrieve
	 * @return A model element used in the test as specified by the test matrix
	 */
	NonRootModelElement selectEPMC(String element) {
		return selectEPMC(element, null);
	}

	/**
	 * "EPMC" is one of the degrees of freedom as specified in this issues test
	 * matrix. This routine gets the "EPMC" instance from the given name.
	 * 
	 * @param element
	 *            The degree of freedom instance to retrieve
	 * @param extraData
	 *            Extra data needed for selection
	 * @return A model element used in the test as specified by the test matrix
	 */
	NonRootModelElement selectEPMC(String element, Object extraData) {
		// not necessary as the test elements are configured during
		// setup
		return null;
	}

	/**
	 * This routine performs the action associated with a matrix cell. The
	 * parameters represent model instances aquired based on the specifed column
	 * instance and row instance.
	 * 
	 * @param columnInstance
	 *            Model instance from the column
	 * @param rowInstance
	 *            Model instance from the row
	 */
	void TL_EPMC_Action(NonRootModelElement columnInstance, NonRootModelElement rowInstance) {
		setupModelExplorer();
		setupCanvas();
		// locate cursor location
		String doc = testDocument.get();
		String name = getName();
		String t = name.substring(4, 7);
		String row = name.split("_")[1];
		String e = row.substring(0, 2);
		int cursorStart = doc.indexOf(t + e);
		int location = cursorStart;
		ActivityEditor editor = (ActivityEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
		// get the word under test
		if(testElement instanceof NonRootModelElement) {
			location = doc.indexOf(((NonRootModelElement) testElement).Get_name());
		} else {
			location = (int) testElement;
		}
		location = cursorStart;
		if (name.contains("P2")) {
			location = cursorStart + 1;
		} else if(name.contains("P3")) {
			IRegion wordRegion = editor.findWord(testDocument, cursorStart);
			location = cursorStart + wordRegion.getLength();
		}		
		// execute the open declaration action
		OpenDeclarationAction action = new OpenDeclarationAction();
		action.setActiveEditor(null,
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor());
		// set the cursor location
		editor.getTextViewer().setSelection(new TextSelection(location, 1));
		
	}

	private void setupCanvas() {
		if (getName().contains("C2")) {
			// open the canvas editor for this test
			CanvasEditorUtils.openEditorWithShapeOf(testBody);
		} else {
			// nothing to do as the tear down makes sure
			// only the editor for the OAL is opened
		}
	}

	private void setupModelExplorer() {
		if (getName().contains("M2")) {
			// open model explorer view
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.showView("org.xtuml.bp.ui.explorer.ExplorerView");
			} catch (PartInitException e) {
				TestCase.fail("Unable to open Model Explorer.");
			}
		} else {
			// nothing to do as the tear down makes sure
			// only the editor for the OAL is opened
		}
	}

	/**
	 * This function verifies an expected result.
	 *
	 * @param source
	 *            A model element instance aquired through a action taken on a
	 *            column of the matrix.
	 * @param destination
	 *            A model element instance aquired through a action taken taken
	 *            on a row of the matrix.
	 * @return true if the test succeeds, false if it fails
	 */
	boolean checkResult_elementShownInMEandCanvas(NonRootModelElement source, NonRootModelElement destination) {
		boolean elementShownInMEandCanvas = false;
		// TODO: Implement
		return elementShownInMEandCanvas;
	}

	/**
	 * This function verifies an expected result.
	 *
	 * @param source
	 *            A model element instance aquired through a action taken on a
	 *            column of the matrix.
	 * @param destination
	 *            A model element instance aquired through a action taken taken
	 *            on a row of the matrix.
	 * @return true if the test succeeds, false if it fails
	 */
	boolean checkResult_transientDeclarationShown(NonRootModelElement source, NonRootModelElement destination) {
		ActivityEditor editor = (ActivityEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
		return testElement.equals(selection.getOffset());
	}

	/**
	 * This function verifies an expected result.
	 *
	 * @param source
	 *            A model element instance aquired through a action taken on a
	 *            column of the matrix.
	 * @param destination
	 *            A model element instance aquired through a action taken taken
	 *            on a row of the matrix.
	 * @return true if the test succeeds, false if it fails
	 */
	boolean checkResult_elementShownInMENotCanvas(NonRootModelElement source, NonRootModelElement destination) {
		// TODO: implement result
		return false;
	}

	/**
	 * This function verifies an expected result.
	 *
	 * @param source
	 *            A model element instance aquired through a action taken on a
	 *            column of the matrix.
	 * @param destination
	 *            A model element instance aquired through a action taken taken
	 *            on a row of the matrix.
	 * @return true if the test succeeds, false if it fails
	 */
	boolean checkResult_elementShownInCanvasNotME(NonRootModelElement source, NonRootModelElement destination) {
		boolean elementShownInCanvasNotME = false;
		// TODO: Implement
		return elementShownInCanvasNotME;
	}

	/**
	 * This function verifies an expected result.
	 *
	 * @param source
	 *            A model element instance aquired through a action taken on a
	 *            column of the matrix.
	 * @param destination
	 *            A model element instance aquired through a action taken taken
	 *            on a row of the matrix.
	 * @return true if the test succeeds, false if it fails
	 */
	boolean checkResult_invalidSelection(NonRootModelElement source, NonRootModelElement destination) {
		boolean invalidSelection = false;
		// TODO: Implement
		return invalidSelection;
	}

}
