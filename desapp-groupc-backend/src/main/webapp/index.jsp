<html style="background-color:grey">
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<head>
  <style>
    * {
      box-sizing: border-box;
    }
    .menu {
      float:left;
      width:20%;
      text-align:center;
    }
    .menu a {
      background-color:#c90e0e;
      padding:8px;
      margin-top:7px;
      display:block;
      width:100%;
      color:black;
    }
    .main {
      float:left;
      width:60%;
      padding:0 20px;
    }
    .right {
      background-color:#c90e0e;
      float:left;
      width:20%;
      padding:15px;
      margin-top:7px;
      text-align:center;
    }

    @media only screen and (max-width:620px) {
      /* For mobile phones: */
      .menu, .main, .right {
        width:100%;
      }
    }
  </style>
</head>
<body>
  <div style="background-color:#c90e0e;padding:15px;text-align:center;">
    <img src="/logo/Logo%20Carpnd.png" style="height: 100px;width: auto">
  </div>

  <div style="overflow:auto">
    <div class="menu">
      <a href="#">Load New Vehicle</a>
      <a href="#">Make Publication</a>
      <a href="#">My Vehicles</a>
      <a href="#">My Rents</a>
    </div>

    <div class="main">
      <h2>(Vehiculo)</h2>
      <p>Foto del Vehiculo</p>
    </div>

    <div class="right">
      <h2>Search</h2>
      <p>Mapa</p>
    </div>
  </div>

  <div style="background-color:#c90e0e;text-align:center;padding:10px;margin-top:7px;">©Copyright - CARPND-GRUPO C</div>
</body>
</html>
