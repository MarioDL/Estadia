use esmarProd
go

create procedure sp_calCostTot
(
  @sal             float
  , @humedad       float
  , @cachete       float
  , @tarimas       float
  , @kgTotales     float
  , @precio        float
  , @piezasTotales int
  , @refParaMerma  int
)
as begin
  declare @salAcep              float
  declare @humedadAcep          float
  declare @cacheteAcep          float
  declare @tarimasAcep          float
  declare @salReal              float
  declare @humedadReal          float
  declare @cacheteReal          float
  declare @tarimasReal          float
  declare @salDiferencia        float
  declare @HumedadDiferencia    float
  declare @cacheteDiferencia    float
  declare @tarimasDiferencia    float
  declare @salDescontar         float
  declare @humedadDescontar     float
  declare @cacheteDescontar     float
  declare @tarimasDescontar     float
  declare @totalKgDescontar     float
  declare @totalDescontar       float
  declare @totalPagar           float
  declare @humedadAcepCalc      float
  declare @idConfigMermaSal     int
  declare @idConfigMermaHumedad int
  declare @idConfigMermaCachete int
  declare @idConfigMermaTarimas int
  
  set @salAcep =
  (
    select
      porcMermaAcep
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 1
      )
  )
  
  set @humedadAcep =
  (
    select
      porcMermaAcep
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 2
      )
  )
  
  set @humedadAcepCalc = @humedadAcep * @kgTotales
  
  set @cacheteAcep =
  (
    select
      porcMermaAcep
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 3
      )
  )
  
  set @tarimasAcep =
  (
    select
      porcMermaAcep
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 4
      )
  )
  
  set @idConfigMermaSal =
  (
    select
      idConfigMerma
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 1
      )
  )
  
  set @idConfigMermaHumedad =
  (
    select
      idConfigMerma
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 2
      )
  )
  
  set @idConfigMermaCachete =
  (
    select
      idConfigMerma
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 3
      )
  )
  
  set @idConfigMermaTarimas =
  (
    select
      idConfigMerma
      
    from
      tb_configMerma
      
    where
      idConfigMerma =
      (
        select
          max(idConfigMerma)
          
        from
          tb_configMerma
          
        where
          idTipoMerma = 4
      )
  )
  
  if (@piezasTotales = 0)
  begin
  
    set @salReal = 0
  end
  
  else
  begin
  
    set @salReal = @sal/@piezasTotales
  end
  
  if (@refParaMerma = 0)
  begin
  
    set @humedadReal = 0
    set @cacheteReal = 0
  end
  
  else
  begin
  
    set @humedadReal = (@humedad/@refParaMerma)*@piezasTotales
    set @cacheteReal = @cachete/@refParaMerma
  end
  
  set @tarimasReal = @tarimas
  
  set @salDiferencia = @salReal-@salAcep
  set @humedadDiferencia = @humedadReal-@humedadAcepCalc
  set @cacheteDiferencia = @cacheteReal-@cacheteAcep
  set @tarimasDiferencia = @tarimasReal-@tarimasAcep
  
  set @salDescontar = @salDiferencia*@piezasTotales
  set @humedadDescontar = @humedadDiferencia
  set @cacheteDescontar = @cacheteDiferencia*@piezasTotales
  set @tarimasDescontar = @tarimasDiferencia
  
  set @totalDescontar = 0
  
  if (@salDescontar > 0)
  begin
  
    select @totalDescontar = @totalDescontar+@salDescontar
  end
  
  if (@humedadDescontar > 0)
  begin
  
    select @totalDescontar = @totalDescontar+@humedadDescontar
  end
  
  if (@cacheteDescontar > 0)
  begin
  
    select @totalDescontar = @totalDescontar+@cacheteDescontar
  end
  
  if (@tarimasDescontar > 0)
  begin
  
    select @totalDescontar = @totalDescontar+@tarimasDescontar
  end
  
  set @totalKgDescontar = @kgTotales-@totalDescontar
  set @totalPagar = @totalKgDescontar*@precio
  
  select
    @totalPagar as totalPagar
    , @salAcep as salAcep
    , @humedadAcepCalc as humedadAcepCalc
    , @cacheteAcep as cacheteAcep
    , @tarimasAcep as tarimasAcep
    , @salReal as salReal
    , @humedadReal as humedadReal
    , @cacheteReal as cacheteReal
    , @tarimasReal as tarimasReal
    , @salDiferencia as salDiferencia
    , @humedadDiferencia as humedadDiferencia
    , @cacheteDiferencia as cacheteDiferencia
    , @tarimasDiferencia as tarimasDiferencia
    , @salDescontar as salDescontar
    , @humedadDescontar as humedadDescontar
    , @cacheteDescontar as cacheteDescontar
    , @tarimasDescontar as tarimasDescontar
    , @totalDescontar as totalDescontar
    , @humedadAcep as humedadAcep
    , @idConfigMermaSal as idConfigMermaSal
    , @idConfigMermaHumedad as idConfigMermaHumedad
    , @idConfigMermaCachete as idConfigMermaCachete
    , @idConfigMermaTarimas as idConfigMermaTarimas
end
go