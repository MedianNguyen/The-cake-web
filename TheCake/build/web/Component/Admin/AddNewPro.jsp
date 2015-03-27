<%-- 
    Document   : AddNewPro
    Created on : May 14, 2014, 4:19:08 AM
    Author     : Link Larkin
--%>

<form action="/EprojectTheCake/AddNewPro" method="post" enctype="multipart/form-data">
    <div>
        Name: <input type="text" name="NameDetailadd" />
        Egg: <input type="text" name="EggDetailadd" />
        Price: <input type="text" name="PriceDetailadd"/>
        Image: <input type="file" name="fileadd"/>
        <input type="submit" value="Add"/>
    </div>
</form>