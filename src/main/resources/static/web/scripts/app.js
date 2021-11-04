//Control de query string para pop-up de alerta 
var urlParams = new URLSearchParams(window.location.search);
var params = Object.fromEntries(urlParams);
if (Object.keys(params).length > 0) {
  if (params.status === "approved") {
    swal({
      title: "Pago aprobado",
      text: "Tipo de pago " + params.payment_type + "\n" + params.external_reference + "\n" + "Numero de operación " + params.payment_id + "\n",
      icon: "success",
    });
  }
  else if (params.status === "in_process") {
    swal({
      title: "Pago pendiente",
      icon: "warning",
    });
  }
  else if (params.status === "rejected") {
    swal({
      title: "Pago rechazado",
      icon: "error",
    });
  }

};

const app = Vue.createApp({
  data() {
    return {
      products: [],
    }

  },

  //almacenamos del backend info del producto en products

  created() {

    var req = {
      method: 'GET',
      redirect: 'follow'
    };

    fetch("/api/products", req)
      .then(response => response.json())
      .then(result => this.products = result)
      .catch(error => console.log('error', error));
  },

  //buyPhone activa el proceso de compra
  methods: {
    buyPhone(phones) {
      var myHeaders = new Headers();
      //enviamos el integrator id y el token de seguridad
      myHeaders.append("x-integrator-id", "dev_24c65fb163bf11ea96500242ac130004");
      myHeaders.append("Authorization", "Bearer APP_USR-6317427424180639-042414-47e969706991d3a442922b0702a0da44-469485398");
      myHeaders.append("Content-Type", "application/javascript");

      // enviamos las preferences solicitadas para la pasarela de pago
      var raw = `{
                "items": [
                  {
                    "id": 1234,
                    "title": "`+ phones.name + `",
                    "description": "`+ phones.description + `",
                    "picture_url": "`+ phones.imgUrl + `",
                    "quantity": `+ phones.stock + `,
                    "unit_price": `+ phones.price + `,
                  }
                ],
                "payer": {
                  "name": "Lalo"
                  "surname": "Landa"
                  "email": "test_user_63274575@testuser.com"
                  "phone": {
                      "area_code": 11,
                      "number": 22223333,
                  },
                  "identification": {},
                  "address": {
                      "street_name":"Calle Falsa",
                      "street_number": "123",
                      "zip_code": "111",
                  }
                },
                "payment_methods": {
                  "excluded_payment_methods": [
                    {
                        "id": "amex"}
                  ],
                  "excluded_payment_types": [
                    {
                        "id": "atm"}
                  ],
                  "installments" : 6,
                },
                "auto_return": "all", 
                "back_urls": {
                  "failure": "https://integrationmpalpha.herokuapp.com/web/index.html",
                  "pending": "https://integrationmpalpha.herokuapp.com/web/index.html",
                  "success": "https://integrationmpalpha.herokuapp.com/web/index.html",
                },
                 "external_reference": "sebastiandavidgraff@gmail.com",
                 "notification_url": "https://integrationmpalpha.herokuapp.com/webhooksmp",
              }`;


      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };
      //recibimos el init point y redirigimos al sitio
      fetch("https://api.mercadopago.com/checkout/preferences", requestOptions)
        .then(response => response.json())
        .then(result => window.location.href = result.init_point)
        .catch(error => console.log('error', error));


    }
  },
})


app.mount("#app")