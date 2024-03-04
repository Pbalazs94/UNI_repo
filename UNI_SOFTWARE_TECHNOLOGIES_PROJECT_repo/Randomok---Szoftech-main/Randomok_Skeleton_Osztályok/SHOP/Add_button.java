//ADD Button
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {    
         int sum = 0;
 
        if(chkBodyguards.isSelected())
        {
            String Bodyguards = "Bodyguards";
            int  price = 700;
            int  qty = Integer.parseInt(txtCqty.getText());
            int tot = price * qty;   
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]          
            {
                Bodyguards,
                price,
                qty,
                tot 
            }        
           );    
        }
         if(chkCrew_Engineer.isSelected())
        {
           String Crew_Engineer  = "Engineers for repairs on the train";
            int  price = 2200;
            int  qty = Integer.parseInt(txtCEqty.getText());
            int tot = price * qty;   
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]          
            {
                Crew_Engineer,
                price,
                qty,
                tot 
            }        
             );    
        }
         
          if(chkPassenger_Space.isSelected())
        {
           String Passenger_Space  = "Passenger Space extension";
            int  price = 1500;
            int  qty = Integer.parseInt(txtPSqty.getText());
            int tot = price * qty;   
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]          
            {
                Passenger_Space,
                price,
                qty,
                tot 
            }        
             );    
        }
          if(chkCargo_Space.isSelected())
        {
           String Cargo_Space  = "Cargo Space extension";
            int  price = 1200;
            int  qty = Integer.parseInt(txtCSqty.getText());
            int tot = price * qty;   
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]          
            {
                Cargo_Space,
                price,
                qty,
                tot 
            }        
             );    
        }
		if(chkCoal_fuel.isSelected())
        {
           String Coal_fuel  = "Buy Coal";
            int  price = 200;
            int  qty = Integer.parseInt(txtCfqty.getText());
            int tot = price * qty;   
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]          
            {
                Coal_fuel,
                price,
                qty,
                tot 
            }        
             );    
        }
		if(chkDiesel_fuel.isSelected())
        {
           String Diesel_fuel  = "Buy Diesel fuel";
            int  price = 800;
            int  qty = Integer.parseInt(txtDfqty.getText());
            int tot = price * qty;   
            model = (DefaultTableModel)jTable1.getModel();
            
            model.addRow(new Object[]          
            {
                Diesel_fuel,
                price,
                qty,
                tot 
            }        
             );    
        }
        for(int i=0; i<jTable1.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(jTable1.getValueAt(i, 3).toString());  
        }
        
        txtbill.setText(Integer.toString(sum));
 }