use esmarProd
go

create procedure sp_actInvCrossSemi
(
  @idInvCrossSemi   int
  , @piezasUtilizar int
)
as begin

  update
    tb_invCrossSemi
    
  set
    noPiezasActuales = noPiezasActuales-@piezasUtilizar
    
  where
    idInvCrossSemi = @idInvCrossSemi
end
go