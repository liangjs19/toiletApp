/*
 * DataSetBindingDemoPanel.java
 *
 * Created on April 29, 2005, 1:48 PM
 */

package org.jdesktop.demo.binding;

import java.io.Serializable;
import javax.swing.JSlider;
import org.jdesktop.binding.DataModel;
import org.jdesktop.binding.JavaBeanDataModel;
import org.jdesktop.binding.swingx.AbstractBinding;
import org.jdesktop.binding.swingx.TextBinding;
import org.jdesktop.demo.DemoPanel;

/**
 *
 * @author  rbair
 */
public class JavaBeanBindingDemoPanel extends DemoPanel {
    private SimpleBean bean;
    
    /** Creates new form DataSetBindingDemoPanel */
    public JavaBeanBindingDemoPanel() {
        setName("Binding to Java Beans");
        initComponents();
        
        bean = new SimpleBean();
        
        try {
            JavaBeanDataModel dm = new JavaBeanDataModel(bean);

            //now to bind
    //        TabularDataModel tdm = new TabularDataModelAdapter(testDS.getTable("Users"));
    //        new DirectListBinding(hackerList, tdm, "name", new SelectionModelAdapter(testDS.getTable("Users").getSelector("current")));
    //        DataModel model = new DataModelAdapter(testDS.getTable("Users").getSelector("current"));
    //        new LabelBinding(idLBL, model, "id");
            TextBinding binding = new TextBinding(nameTF, dm, "name");
            binding.pull();
    //        new RadioBinding(mfRadioGroup, model, "gender");
    //        new BooleanBinding(developerCHK, model, "developer");
    //        new ComboBoxBinding(langCB, model, "primary_language");
    //        new CustomSliderBinding(skillSlider, model, "skill_level");
    //        new TextBinding(notesTA, model, "notes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getHtmlDescription() {
        return "<html>This demo shows the results of binding various UI " +
                "components to a JavaBean.";
    }

//    private static void loadTestDataSet(DataSet ds) {
//        DataTable users = ds.getTable("Users");
//        appendUser(users, 100, "John Doe", "Male", true, "English", 4, "Nice guy");
//        appendUser(users, 101, "Jane Doe", "Female", true, "English", 6, "Not related to John Doe, amazingly enough");
//        appendUser(users, 120, "Harry Hacker", "Male", true, "French", 9, "Remarkable fello!");
//        appendUser(users, 300, "Marlaina S. Coder", "Female", true, "German", 8, "Oh boy can she code!");
//    }
    
//    private static DataRow appendUser(DataTable users, int id, String name, 
//            String gender, boolean dev, String lang, int skillz, String notes) {
//        DataRow user = users.appendRowNoEvent();
//        user.setValue("id", id);
//        user.setValue("name", name);
//        user.setValue("gender", gender);
//        user.setValue("developer", dev);
//        user.setValue("primary_language", lang);
//        user.setValue("skill_level", skillz);
//        user.setValue("notes", notes);
//        user.setStatus(DataRow.DataRowStatus.UNCHANGED);
//        return user;
//    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        hackerList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idLBL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        developerCHK = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        langCB = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        skillSlider = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notesTA = new javax.swing.JTextArea();
        mfRadioGroup = new org.jdesktop.swingx.JXRadioGroup();
        mfRadioGroup.add("Male");
        mfRadioGroup.add("Female");

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(hackerList);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Bound JLabel:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        nameTF.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 0, 11);
        jPanel1.add(nameTF, gridBagConstraints);

        jLabel2.setText("Bound JTextField:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        idLBL.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 0, 11);
        jPanel1.add(idLBL, gridBagConstraints);

        jLabel4.setText("Bound JXRadioGroup:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Bound JCheckBox:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        developerCHK.setText("Developer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 0, 11);
        jPanel1.add(developerCHK, gridBagConstraints);

        jLabel6.setText("Bound JComboBox:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        langCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "English", "French", "German", "Spanish", "Russian" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 0, 11);
        jPanel1.add(langCB, gridBagConstraints);

        jLabel7.setText("Bound JSlider:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);

        skillSlider.setMajorTickSpacing(1);
        skillSlider.setMaximum(10);
        skillSlider.setMinorTickSpacing(1);
        skillSlider.setPaintLabels(true);
        skillSlider.setPaintTicks(true);
        skillSlider.setSnapToTicks(true);
        skillSlider.setToolTipText("Select the skill level of the developer, 1 being lowest, 10 being highest");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 0, 11);
        jPanel1.add(skillSlider, gridBagConstraints);

        jLabel8.setText("Bound JEditorPane:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        jScrollPane3.setViewportView(notesTA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 11, 11);
        jPanel1.add(jScrollPane3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 0, 11);
        jPanel1.add(mfRadioGroup, gridBagConstraints);

        jSplitPane1.setRightComponent(jPanel1);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox developerCHK;
    private javax.swing.JList hackerList;
    private javax.swing.JLabel idLBL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox langCB;
    private org.jdesktop.swingx.JXRadioGroup mfRadioGroup;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextArea notesTA;
    private javax.swing.JSlider skillSlider;
    // End of variables declaration//GEN-END:variables
    
    public static final class CustomSliderBinding extends AbstractBinding {
        private JSlider slider;
        
        
        public CustomSliderBinding(JSlider slider, DataModel model, String fieldName) {
            super(slider, model, fieldName, AbstractBinding.AUTO_VALIDATE_NONE);
        }
        
        protected void setComponent(javax.swing.JComponent component) {
            assert component instanceof JSlider;
            slider = (JSlider)component;
        }

        protected void setComponentValue(Object value) {
            if (value instanceof Number) {
                slider.setValue(((Number)value).intValue());
            }
        }

        protected Object getComponentValue() {
            return slider.getValue();
        }

        public javax.swing.JComponent getComponent() {
            return slider;
        }
        
    }
    
     
    public class SimpleBean implements Serializable {

        private String name = "<name>";

        public SimpleBean(){}

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
