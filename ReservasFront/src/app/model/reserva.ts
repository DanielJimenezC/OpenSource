import { MedioPago } from "./mediopago";
import { Restaurant } from "./restaurant";
import { Tipo } from "./tipo";

export class Reserva{
    id:number;
    nombre:string;
    cantidad:number;
    fecha:string;
    medio:MedioPago;
    restaurante:Restaurant;
    tipo:Tipo;
}