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


Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.


G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.


H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.


I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.


J.  Remove the class files for any unused validators in order to clean your code.