use esmarProd
go

if exists (select name from sys.sysobjects WHERE name = 'sp_obtPrecioVenta')
begin 
  drop
    procedure sp_obtPrecioVenta
end
go

create procedure sp_obtPrecioVenta
(
  @idTipoRecorte    int
  , @idCalibre     int
  , @idSeleccion int
)
as begin
  
  select
    tr.descripcion as tipoRecorte
    , c.descripcion as calibre
    , s.descripcion as seleccion
    , pv.precio
    , pv.unidadMedida
    , pv.fecha
    , pv.idPrecioVenta
    
  from
    tb_PrecioVenta as pv
  inner join
    tb_tipoRecorte as tr
  on
    pv.idTipoRecorte = tr.idTipoRecorte
  
  inner join
    tb_calibre as c
  on
    pv.idCalibre = c.idCalibre
    
  inner join
    tb_seleccion as s
  on
    pv.idSeleccion = s.idSeleccion
    
  where
  (
    (
      @idSeleccion = 0
      and pv.idSeleccion > 0
    )
    or
    (
      @idSeleccion > 0
      and pv.idSeleccion = @idSeleccion
    )
  )
  and
  (
    (
      @idCalibre = 0
      and pv.idCalibre > 0
    )
    or
    (
      @idCalibre > 0
      and pv.idCalibre = @idCalibre
    )
  )
  and
  (
    (
      @idTipoRecorte = 0
      and pv.idTipoRecorte > 0
    )
    or
    (
      @idTipoRecorte > 0
      and pv.idTipoRecorte = @idTipoRecorte
    )
  )
end
go