Change Log:
XSTAMPP 2.3.1:
	Features:
		- Move Components in the control structure Up and Down by right clicking on them
	Bugfixes:
	Others:
		- COntrol Structure Components are now added in the front level/ at the bottom of a list
XSTAMPP 2.3.0:
	Features:
		- Added Project Settings Dialog in 'Project->Project Settings' and the context menu of the project explorer
		- Added Project Menu with Project Settings in the main menu bar of XSTAMPP
		- Added User System for creating multiple users/admins/'read only' users
			- Added login Dialog to prevent unregistered access
			- Added 'User' page in the Project Settings Dialog 
			- Added 'Collaboration' page in the Project Settings Dialog for creating working copies per user
		- Added a '[READ_ONLY]' indicator in the project explorer and the title bar of the program window
		- Added a '*' indicator in the project explorer and the title bar of the program window to mark projects that need saving 
		- Added Undo/Redo Buttons in the main toolbar of XSTAMPP to undo/redo changes in:
			- Accidents Table
			- Hazards Table
			- Safety Constraints Table
			- System Goals Table
			- Design Requirements Table
			- Unsafe Control Action Description
			- Control Actions Table
			- Corresponding Safety Constraints
			- Causal Factors Description and Notes
		
	Bugfixes:
		-Fixed bug where XSTAMPP would sometimes create 'null.ext' files
		- Fixed Bug that caused unsafed changes to be dismissed without promt when the user clicked on 'File->Switch Workspace'
		- Fixed Bug that caused the project to crash when clicking the save button very often and very quickly
	
	Others:
		- Changed second column of Unsafe Control Actions Table from 'Providing causes hazard' to 'Providing incorrect causes hazard'
		- Removed 'unused' toolbar items form the main toolbar
	
	A-STPA 2.3.0 Features:
		- Added project specific option to safe preferences to hide/show scenarios
		- Added project specific option to safe preferences to hide/show hazard severity analysis
	A-STPA 2.3.0 Bugfixes:
		- Fixed Bug where the connection anchor sometimes diappeared when trying to connect two components
		- Fixed Bug that disabled the snap-to feature for connecting a component when inside a dashed box
		- Fixed Bug that caused source/target components(in the control action table) of a control action to stay the same even if the control action had been moved to a new connection in the control structure
		- Fixed Bug in the control structure diagram that caused the arrow head of a connection to point in the wrong direction
		- Fixed Bug that would prevent entries in the Table Views to be moved up/down 
			
	A-CAST 1.0.5 Bugfixes:
		- Fixed Bug that would prevent storage of the responsibilities
XSTAMPP 2.0.1:

	Features:
		- Added 'Install New Software' menu to manually install/deinstall features and plugins for xstampp
		- Updates are now available over the Edit->Preferences->Install/Update preferences please see adapt these preferences to build your update schedule
	
	Improvements:
		- Enhanced Load and Save Funktion to prevent data loss
		- Enhanced preference function of the project explorer to sort projects and change fonts
	
	Bugfixes:
		- Fixed errors when shutting down XSTAMPP with jobs still running
		- enhanced error dialogs of load/save
		
	A-STPA 2.0.4 Features:
		- enhanced id mapping of safety Constraints/Control Actions and UCAs
		-  Show/Hide the border of the "List of Control Actions" Component
   		-  Show/Hide of the border of the process variable in the control structure
	

	A-STPA 2.0.4 Bugfixes:
	
		- fixed a bug that sometimes xstampp breaks down when performing any changes
		- fixed the bug that sometimes the text entered text in the UCA and Causal Factors table deleted when 
			closing the editor
			
	XSTPA 1.0.1 Features:
		-  New delete/delete all function in refined rules table
		-  LTL Formulas in context 'control action provided' are now derived in timed ltl
		-  Integration of the Refined UCA, Refined Safety Constraints and LTL Formulas table in the xstpa subtree 
		-  Support for automatically generated the rules of the refined unsafe control action based on the critical combinations and add them in column rules in rules table.
		-  Enhanced adding and editing of value/(don't care) entries in the context table
		-  Export function for context tables, refined unsafe control actions, rules,safety constraints and ltl properties 
		-  Added Acts algorithm in the installation folder so that it not longer has to be added manually
	

	XSTPA 1.0.1 Bugfixes:
		- ACTS algorithm can now be executed for more than 9 variables
		- Values that are marked as (don't care) can now be restored to any available value 
		- Enhanced 'check for conflicts' function in the context table
		- Fixed a bug that led to loss of changes in the Context Tables configuration dialog
		- enhanced the performance of the xstpa view 
		- fixed the bug that sometimes the Scrollbars are not displayed when needed
	

XSTAMPP 2.0.0:

	Features: 
	1- Create CAST Project and STPA project in the project explorer.
	1- �One-Click� generate all reports of your STPA or CAST work in different formats e.g. PDF, image and CSV by clicking one button. 
	2- Edit a large amount of data in the unsafe control actions table, by filtering the entries.
	3- In the control structure you can merge multiple control action components into one 
		�List of Control Actions� component
	3- In the control structure you can link between the control action and arrows, to attach source and destination to the control action.
	4- Automatically generate the context tables and LTL formal specification and apply different coverages criteria on the context table to reduce the number of combinations. 
	5- Choose between �fixed� or flexible connection points on each component in the control structure diagram. 
	6- Copy & Paste feature in the control structure diagram. 

	Bugsfixes: 
	1 - The toolbar does not appear correctly with large screen resolutions
	2 - In the control structure Dashed Boxes should always be drawn behind other objects
	4 - I cannot create a new project with STPA wizard
	5 - change the font in system description by mouse is very hard
	6 - Null Pointer when trying to delete a List of Control Actions
	7 - the table headers and column names in the cf and ucs table are not displayed correctly
	8 - On mac in the UCA Table the dialoge for linking Hazards does not appear
	9 - Accidents/hazzards without a long description doesn't show up in the linking view
	10 - The toolbar does not appear correctly with large resolutions of large laptop screen.
	11 - Components in the control structure should have distinguishable names
	12 - The Export function sometimes fails with an error
	13 - It is diffcult to move and select the control action list
    14 - I cannot generate the reports from the run button with a project which has a file with .haz

A-STPA 2.0.1

	Features:
	- Font in Control Structure (Step 1.8/3.1) now changable in Preferences
	
	Bugfixes:
	- fixed bug that caused special characters to be stored in a wrong format
	- added compability mode for disabeling the above bugfix to guaranty compabillity with older versions
	  (in this mode the bug still exists so its not recommended to store special characters with it!!)
	- disabled connection constraints to enable the users to set connections in the control structure
	  at will
	- fixed bug with dublicated toolbars
	


XSTAMPP 1.0.0/A-STPA 2.0.0
	Since this version A-STPA is now part of the eXtensible STAMP Platform (XSTAMPP)
	it is now provided as fully integrated plug-in.
 	Due to this A-STPA has now got a whole new appearance which should enable the user
	to use it in a far more flexible way. Features: �Possibility of managing multiple projects
	at the same time thanks to the XSTAMPP project explorer 

	Features:
	- Font in Control Structure (Step 1.8/3.1) now changable in Preferences
	- toolbars now provided in the main toolbar of the workbench 
	- Renaming Projects directly in the project explorer 
	- Preference Option to highlight selected step in Edit/Preferences/Color and Fonts

	Bugfixes:
	- controlstructure images are now exported in higher quality
	- Fixed Bug that links between causal factors and hazards were not stored
	- 
	


1.0.5:

	Features:
	- added Help Content with contact link
	- added Version History and quickstartguide as in Help->Help Content
	

	Bugfixes:
	- final bugfix of the control structure image resolution bug in the PDF Export #64
	- added save and load status monitor #38
	- fixed bug #80 CS-Editor: Control Action not working correctly 
		
1.0.4:
	
	Features:
	- added decoration mode in the Control Structure, which adds icons and Colored borders for a better 	  	  distinguishability for the components

	Bugfixes:
	- fixed wrong scaling of the control structure image in the pdf Export
	- Components which are created in the Control Structure are not longer removeable in the Control 	  	  Structure with process model

1.0.3:
	Features:
	- added Export function of all Data as Data Sheet, Image and PDF Export 
	- added Contact Data in the About Dialog
	- added ControlAction Component in the ControlStructure,linked with the ControlActionsView 

1.0.2:

    	Bugfixes:
	- enhanced the handling of the hazard linking Dialog in the 'Unsafe Control Actions  Table'
    	- prevent components from beeing dragged out of sight
	- adapt the Control Structure Export image
	- it's now possible to change the height and width of the Values and Variables inside the Proicess Modell
	- enhanced undo/Redo
	- improved popup for safety Constraint linking in the Causal analysis

  