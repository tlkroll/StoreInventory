# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
    
    Modified HTML in mainscreen.html:
    Line 14 - Changed page title from "My Bicycle Shop" to "Tom's Gun Shop"
    Line 19 - Changed header from "Shop" to "Tom's Gun Shop" to match title

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

    Created new HTML file about.html:
    Lines 5-11 - Copied meta tags and bootstrap CSS from existing html project files to keep user interface style consistent
    Line 13 - Changed page title to "About Us"
    Line 14 - Added header "About Tom's Gun Shop"
    Line 15 - Added horizontal line to match style on mainscreen.html
    Lines 16-19 Added a brief description of Tom's Gun Shop
    Line 20 - Added link to return to main page
    
    Created new controller AboutController.java:
    Lines 1-3 - Imported necessary packages to map requests to /about.html
    Lines 5-11 - Created controller and getmapping to map to /about.html

    In mainscreen.html:
    Line 89 - Added link to about page

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

    In BootStrapData.java:
    Lines 35 & 96 - Conditional statement to check that parts and product lists are empty before adding sample inventory
    Lines 36-85 - Added parts to inventory on condition parts and product lists are empty
    Lines 86-95 - Added products to inventory on condition parts and product lists are empty

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

    Created templates buySuccess.html and buyFail.html which show success or failure of "Buy Now"
    
    In mainscreen.html:
    Line 86 - Added line for "Buy Now" button

    Created controller BuyNow.java: 
    Line 87 - Buy Now button points to BuyNow controller 
    Lines 88-105 - If inventory is 0, BuyNow redirects to buyFail.html. If inventory > 0, inventory for that product is 
    decremented by one and BuyNow redirects to buySuccess.html

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

    In Part.java:
    Lines 31-34 - Defined minInventory and maxInventory variables
    Lines 44, 48, 49, 52, 57, 58 - Defined constructors for minInventory and maxInventory
    Lines 95-107 - Defined setters and getters getMin, setMin, getMax, setMax for minInventory and maxInventory
    
    In BootStrapData.java:
    Lines 42, 43, 52, 53, 62, 63, 72, 73, 82, 83 - Added minInventory and maxInventory values for sample parts
    
    In mainscreen.html:
    Lines 38, 39, 49, 50 - Added table headers and data items for minInventory and maxInventory in Parts table
    
    In InHousePartForm.html:
    Lines 25 & 26 - Added input fields for minimum and maximum inventory

    In OutsourcedPartForm.html:
    Lines 25 & 26 - Added input fields for minimum and maximum inventory

    In application.properties after renaming database file:
    Line 6 - spring.datasource.url=jdbc:h2:file:~/new-db-name

    In Part.java:
    Lines 60-67 - Added method to verify that inventory count falls between min and max values

    In AddInhousePartController.java:
    Lines 44-46 - Added conditional statement using inventory validation method created in previous step which
    returns the form if inventory value is outside valid range
    
    In AddOutsourcedPartController.java:
    Lines 44-46 - Added conditional statement using inventory validation method created in previous step which
    returns the form if inventory value is outside valid range

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.
    
    Created minerror.html and maxerror.html to display more specific errors when adjusting inventory

    In AddOutsourcedPartController.java:
    Lines 46-51 - Modified conditional statement created in last step to point to minerror.html or maxerror.html

    In AddInhousePartController.java:
    Lines 45-50 - Modified conditional statement created in last step to point to minerror.html or maxerror.html

    In AddProductController.java:
    Lines 83-85 - Added conditional statement that returns minerror.html if creating the product would reduce parts
    inventory below minimum when creating a product

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

    In PartTest.java:
    Lines 31-46 - Added four unit tests to check operation of isInvValid method. Checks both Inhouse and Outsourced
    parts against values of 0 and 999

J.  Remove the class files for any unused validators in order to clean your code.