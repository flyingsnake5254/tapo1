package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public List<ConstraintWidgetGroup> mWidgetGroups;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mChildren.get(i2).analyze(i);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01dd  */
    /* JADX WARN: Type inference failed for: r8v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layout() {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    public void optimizeForDimensions(int i, int i2) {
        ResolutionDimension resolutionDimension;
        ResolutionDimension resolutionDimension2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (!(dimensionBehaviour == dimensionBehaviour2 || (resolutionDimension2 = this.mResolutionWidth) == null)) {
            resolutionDimension2.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != dimensionBehaviour2 && (resolutionDimension = this.mResolutionHeight) != null) {
            resolutionDimension.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetResolutionNodes();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == dimensionBehaviour2 && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }
}
